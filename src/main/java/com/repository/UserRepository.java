package com.repository;

import com.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select e from User e where e.email = :email")
    Optional<User> findByEmail(@PathParam("email") String email);

    Optional<User> findByPasswordAndEmail(String password, String email);
}
