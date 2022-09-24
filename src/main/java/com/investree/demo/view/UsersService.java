package com.investree.demo.view;

import com.investree.demo.model.Users;

import java.util.Map;

public interface UsersService {
  public Map insert(Users obj);

  public Map getAllUsers();

  public Map getByUsername(String username, Integer page, Integer size);

  public Map update(Users users, Long iduser);
}
