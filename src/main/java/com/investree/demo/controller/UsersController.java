package com.investree.demo.controller;

import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.UsersService;
import com.investree.demo.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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

  @GetMapping("/listByUsername")
  public ResponseEntity<Page<Users>> getByUsername(
      @RequestParam() Integer page,
      @RequestParam() Integer size,
      @RequestParam() String username) {
    Pageable show_data = PageRequest.of(page, size);
    Page<Users> list = userRepository.getByUsername(username, show_data);
    return new ResponseEntity<Page<Users>>(list, new HttpHeaders(), HttpStatus.OK);
  }

  @PostMapping("/save")
  public ResponseEntity<Map> save(@RequestBody Users objModel) {
    Map save = userService.insert(objModel);
    return new ResponseEntity<Map>(save, HttpStatus.OK);
  }
}
