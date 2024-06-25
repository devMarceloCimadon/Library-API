package proj.crud.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.crud.library.dto.user.CreateUserDto;
import proj.crud.library.dto.user.UpdateUserDto;
import proj.crud.library.entity.User;
import proj.crud.library.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto){
        var userId = userService.createUser(createUserDto);
        //Retorna uma url com o id do usuário recém criado
        return ResponseEntity.created(URI.create("/api/users/" + userId.toString())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
        var user = userService.getUserById(userId);
        //Um if or Else que verifica se foi realizado, se foi ele retorna ok pegando o user e retornando, senão ele retorna not found
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        var users = userService.listUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId, @RequestBody UpdateUserDto updateUserDto){
        userService.updateUserById(userId, updateUserDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") String userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }
}
