package com.investree.demo.view;

import com.investree.demo.model.Transaksi;

import java.util.Map;

public interface TransaksiService {
  public Map save(Transaksi objModel);

  public Map updateStatus(Transaksi objModel);
}
