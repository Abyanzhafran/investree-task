package com.investree.demo.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "users")

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password")
  private String password;
}