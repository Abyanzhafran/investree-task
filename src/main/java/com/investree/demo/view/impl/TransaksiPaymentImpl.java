package com.investree.demo.view.impl;

import org.springframework.stereotype.Service;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TransaksiPaymentImpl implements TransaksiService {

  @Autowired
  public TransaksiRepository transaksiRepository;

  @Override
  public Map save(Transaksi obj) {
    Map map = new HashMap();
    try {
      Transaksi save = transaksiRepository.save(obj);
      map.put("data", save);
      map.put("code", "200");
      map.put("status", "success");
      return map;
    } catch (Exception e) {
      map.put("code", "500");
      map.put("status", "failed");
      return map;
    }
  }

  @Override
  public Map updateStatus(Transaksi transaksi, Long idtransaksi) {
    Map map = new HashMap();
    try {
      Transaksi obj = transaksiRepository.getById(transaksi.getId());

      if (obj == null) {
        map.put("statusCode", "404");
        map.put("statusMessage", "Data id tidak ditemukan");
        return map;
      }

      obj.setStatus(transaksi.getStatus());
      transaksiRepository.save(obj);

      map.put("data", obj);
      map.put("statusCode", "200");
      map.put("statusMessage", "Update Sukses");
      return map;

    } catch (Exception e) {
      e.printStackTrace();
      map.put("statusCode", "500");
      map.put("statusMessage", e);
      return map;
    }
  }
}
