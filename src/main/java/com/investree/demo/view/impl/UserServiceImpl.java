package com.investree.demo.view.impl;

import org.springframework.stereotype.Service;

import com.investree.demo.model.User;
import com.investree.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    super();
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
