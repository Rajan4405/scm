package com.scm.scm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.scm.entities.User;

public interface UserRepo extends JpaRepository<User, String> {
  // extra methods db relatedOperation
  // custom query methods
  // custom finder methods

  Optional<User> findByEmail(String email);
}
