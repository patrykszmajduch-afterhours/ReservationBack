package rest.angular.demo.data;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "UsersCredentials")
@Data
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    private String password;
    private String role;
}
