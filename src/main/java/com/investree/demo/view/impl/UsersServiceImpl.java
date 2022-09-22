package com.investree.demo.view.impl;

import org.springframework.stereotype.Service;

import com.investree.demo.model.Users;
import com.investree.demo.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

  @Autowired
  public UsersRepository userRepository;

  @Override
  public Map getAllUsers() {
    List<Users> list = new ArrayList<Users>();
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