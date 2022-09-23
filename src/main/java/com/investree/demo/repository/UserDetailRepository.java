package com.investree.demo.repository;

import com.investree.demo.model.UserDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

  // @Query("SELECT x FROM userdetail x")
  // public List<UserDetail> getList();
}
