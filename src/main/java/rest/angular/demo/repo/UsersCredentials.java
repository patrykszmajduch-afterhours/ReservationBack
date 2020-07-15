package rest.angular.demo.repo;

import org.springframework.data.repository.CrudRepository;

import rest.angular.demo.data.UserCredentials;

import java.util.List;

public interface UsersCredentials extends CrudRepository<UserCredentials,Long> {
    UserCredentials findFirstByUsername(String username);
}
