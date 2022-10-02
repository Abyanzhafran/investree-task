package com.investree.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_detail")

public class UsersDetail implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private Users detailUser;

  @Column(name = "nama", nullable = false)
  private String nama;

  @Column(name = "alamat", nullable = false)
  private String alamat;
}
