package com.carlosborges.movieflix.repository;

import com.carlosborges.movieflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserDetails > findUserByEmail(String email);
}
