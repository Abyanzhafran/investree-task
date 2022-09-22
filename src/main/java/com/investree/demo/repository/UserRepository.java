package com.investree.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.investree.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
