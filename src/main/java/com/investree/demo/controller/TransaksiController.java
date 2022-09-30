package com.investree.demo.controller;

import com.investree.demo.view.TransaksiService;
import com.investree.demo.model.Transaksi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {

  @Autowired
  public TransaksiService transaksiService;

  @PostMapping("")
  public ResponseEntity<Map> save(@RequestBody Transaksi objModel) {
    Map save = transaksiService.save(objModel);
    return new ResponseEntity<Map>(save, HttpStatus.OK);
  }

  @PutMapping("")
  public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objModel) {
    Map update = transaksiService.updateStatus(objModel);
    return new ResponseEntity<Map>(update, HttpStatus.OK);
  }
}
