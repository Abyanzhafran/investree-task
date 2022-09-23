package com.investree.demo.repository;

import com.investree.demo.model.UsersDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDetailRepository extends JpaRepository<UsersDetail, Long> {

}
