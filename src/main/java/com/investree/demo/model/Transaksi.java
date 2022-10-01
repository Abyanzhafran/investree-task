package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Data
@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "id_peminjam")
  private int id_peminjam;

  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_meminjam", referencedColumnName = "id")
  private Users transaksi;

  @Column(name = "tenor")
  private int tenor;

  @Column(name = "total_pinjaman")
  private Double total_pinjaman;

  @Column(name = "bunga_persen")
  private Double bunga_persen;

  @Column(name = "status")
  private String status;

  @JsonIgnore
  @OneToOne(mappedBy = "paymentHistory")
  private PaymentHistory paymentHistory;
}
