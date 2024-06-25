package proj.crud.library.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @CreationTimestamp
    private Instant creationTimestamp;
    @UpdateTimestamp
    private Instant updateTimestamp;

    public User() {
    }

    public User(UUID userId, String name, String email, Instant creationTimestamp, Instant updateTimestamp) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }
}
