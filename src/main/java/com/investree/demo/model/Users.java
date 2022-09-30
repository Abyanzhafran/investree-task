package com.investree.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "users")

public class Users implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "is_active")
  private Boolean is_active;

  @JsonIgnore
  @OneToOne(mappedBy = "detailUser")
  private UsersDetail detail;
}