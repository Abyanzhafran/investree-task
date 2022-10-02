package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Data
@Entity
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_transaksi", referencedColumnName = "id")
  private Transaksi paymentHistory;

  @Column(name = "pembayaran_ke")
  private int pembayaran_ke;

  @Column(name = "jumlah")
  private Double jumlah;

  @Column(name = "bukti_pembayaran")
  private String bukti_pembayaran;
}
