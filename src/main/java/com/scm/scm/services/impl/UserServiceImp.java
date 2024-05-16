package com.scm.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm.entities.User;
import com.scm.scm.helpers.ResourceNotFoundException;
import com.scm.scm.repository.UserRepo;
import com.scm.scm.services.UserService;

@Service
public class UserServiceImp implements UserService {

  @Autowired(required = true)
  private UserRepo userRepo;

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public User saveUser(User user) {

    // user id : have to generate it
    String userId = UUID.randomUUID().toString();
    user.setUserId(userId);
    // password encode
    // user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepo.save(user);

  }

  @Override
  public Optional<User> getUserById(String id) {
    return userRepo.findById(id);
  }

  @Override
  public Optional<User> updateUser(User user) {
    User userExist = userRepo.findById(user.getUserId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    userExist.setName(user.getName());
    userExist.setEmail(user.getEmail());
    userExist.setPassword(user.getPassword());
    userExist.setAbout(user.getAbout());
    userExist.setPhoneNumber(user.getPhoneNumber());
    userExist.setProfile(user.getProfile());
    userExist.setEnabled(user.isEnabled());
    userExist.setEmailVerified(user.isEmailVerified());
    userExist.setPhoneVerified(user.isPhoneVerified());
    userExist.setProvider(user.getProvider());
    userExist.setProviderUserId(user.getProviderUserId());

    User save = userRepo.save(userExist);

    return Optional.ofNullable(save);

  }

  @Override
  public void deleteUser(String id) {
    User userExist = userRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    userRepo.delete(userExist);
  }

  @Override
  public boolean isUserExist(String userId) {
    User userExist = userRepo.findById(userId).orElse(null);
    return userExist != null ? true : false;

  }

  @Override
  public boolean isUserExistByEmail(String email) {
    User user = userRepo.findByEmail(email).orElse(null);
    return user != null ? true : false;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

}
