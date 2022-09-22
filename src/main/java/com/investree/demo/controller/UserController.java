package com.investree.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.investree.demo.model.User;
import com.investree.demo.view.impl.UserService;

@RestController
@RequestMapping("/api/investree_fp")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    super();
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAlUsers() {
    return userService.getAllUsers();
  }
}
