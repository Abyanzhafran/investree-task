package com.investree.demo.view.impl;

import org.springframework.stereotype.Service;

import com.investree.demo.model.Users;
import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UsersImpl implements UsersService {

  @Autowired
  public UsersRepository usersRepository;

  @Override
  public Map getAllUsers() {
    List<Users> list = new ArrayList<Users>();
    Map map = new HashMap();
    try {

      list = usersRepository.getList();
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

  @Override
  public Map insert(Users obj) {
    Map map = new HashMap();
    try {
      Users save = usersRepository.save(obj);
      map.put("data", save);
      map.put("code", "200");
      map.put("status", "success");
      return map;
    } catch (Exception e) {
      map.put("code", "500");
      map.put("status", "failed");
      return map;
    }

  }
}