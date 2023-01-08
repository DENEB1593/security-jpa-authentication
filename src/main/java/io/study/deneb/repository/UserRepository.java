package io.study.deneb.repository;

import io.study.deneb.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUsername(String username);
}
