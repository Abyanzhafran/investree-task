package com.investree.demo.controller;

import com.investree.demo.repository.UserRepository;
import com.investree.demo.view.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users/")
public class UserController {

  @Autowired
  public UserRepository userRepository;

  @Autowired
  UserService userService;

  @GetMapping("/listUser")
  @ResponseBody
  public ResponseEntity<Map> getList() {
    Map c = userService.getAllUsers();
    return new ResponseEntity<Map>(c, HttpStatus.OK);
  }
}
