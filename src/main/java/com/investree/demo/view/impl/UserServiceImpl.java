package com.investree.demo.view.impl;

import org.springframework.stereotype.Service;

import com.investree.demo.model.User;
import com.investree.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  public UserRepository userRepository;

  @Override
  public Map getAllUsers() {
    List<User> list = new ArrayList<User>();
    Map map = new HashMap();
    try {

      list = userRepository.getList();
      map.put("data", list);
      map.put("statusCode", 200);
      map.put("statusMessage", "Get Sukses");
      return map;

    } catch (Exception e) {
      e.printStackTrace();
      map.put("statusCode", "500");
      map.put("statusMessage", e);
      return map;
    }
  }
}