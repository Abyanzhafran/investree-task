package com.investree.demo.repository;

import com.investree.demo.model.Users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {
  @Query("SELECT c FROM Users c")
  public List<Users> getList();

  @Query("SELECT c FROM Users c WHERE c.username = :username")
  Page<Users> getByUsername(String username, Pageable pageable);
}
