package com.investree.demo.repository;

import com.investree.demo.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
  @Query("SELECT c FROM User c")
  public List<User> getList();
}
