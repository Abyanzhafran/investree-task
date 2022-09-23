package com.investree.demo.view;

import java.util.Map;

import com.investree.demo.model.Users;

public interface UsersService {
  public Map insert(Users obj);

  public Map getAllUsers();
}
