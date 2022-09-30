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
      map.put("status", "sukses");
      map.put("code", "200");
      return map;
    } catch (Exception e) {
      map.put("code", "500");
      map.put("status", "failed");
      return map;
    }
  }

  @Override
  public Map updateStatus(Transaksi objModel) {
    Map map = new HashMap();
    try {
      Transaksi update = transaksiRepository.getById(objModel.getId());
      update.setStatus(objModel.getStatus());
      Transaksi doSave = transaksiRepository.save(update);
      map.put("data", doSave);
      map.put("status", "sukses");
      map.put("code", "200");
    } catch (Exception e) {
      map.put("code", "500");
      map.put("status", "failed");
      return map;
    }
    return map;
  }
}
