package com.example.website.repositories;

import com.example.website.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
//    List<User> findUserByEmail(String email);

    User findById(long id);

    Optional<User> findUserByEmail(String email);


}
