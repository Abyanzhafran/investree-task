package com.investree.demo.controller;

import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.UsersService;
import com.investree.demo.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user/")
public class UsersController {

  @Autowired
  public UsersRepository userRepository;

  @Autowired
  UsersService userService;

  @GetMapping("/listUser")
  @ResponseBody
  public ResponseEntity<Map> getList() {
    Map c = userService.getAllUsers();
    return new ResponseEntity<Map>(c, HttpStatus.OK);
  }

  @PostMapping("/save")
  public ResponseEntity<Map> save(@RequestBody Users objModel) {
    Map save = userService.insert(objModel);
    return new ResponseEntity<Map>(save, HttpStatus.OK);
  }
}
