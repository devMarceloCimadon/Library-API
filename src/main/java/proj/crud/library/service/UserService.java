package proj.crud.library.service;

import org.springframework.stereotype.Service;
import proj.crud.library.dto.user.CreateUserDto;
import proj.crud.library.dto.user.UpdateUserDto;
import proj.crud.library.entity.User;
import proj.crud.library.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Cria o usuário e retorna o id dele
    public UUID createUser(CreateUserDto createUserDto){
        var entity = new User(UUID.randomUUID(), createUserDto.name(), createUserDto.email(), Instant.now(), null);
        var userSaved = userRepository.save(entity);
        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId){
        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto){
        var id = UUID.fromString(userId);
        var userEntity = userRepository.findById(id);
        // Verifica se o usuário existe
        if (userEntity.isPresent()){
            var user = userEntity.get();
            // Caso exista e o DTO tenha um email, ele atualiza o email do DTO para o User
            if (updateUserDto.email() != null){
                user.setEmail(updateUserDto.email());
            }
            // Faz a atualização do email no banco
            userRepository.save(user);
        }
    }

    public void deleteUserById(String userId){
        var id = UUID.fromString(userId);
        var userExists = userRepository.existsById(id);
        if(userExists) {
            userRepository.deleteById(id);
        }
    }
}
