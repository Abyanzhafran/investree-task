package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, Long> {

  @Query("SELECT c FROM Transaksi c WHERE c.id = :id")
  public Transaksi getById(@Param("id") long id);

  @Query("SELECT c FROM Transaksi c")
  Page<Transaksi> getList(Pageable pageable);

  @Query("SELECT c FROM Transaksi c WHERE c.status LIKE :status")
  Page<Transaksi> findByStatusLike(String status, Pageable pageable);

}
