package proj.crud.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.crud.library.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
