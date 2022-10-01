package com.investree.demo.controller;

import com.investree.demo.view.TransaksiService;
import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {

  @Autowired
  public TransaksiService transaksiService;

  @Autowired
  public TransaksiRepository transaksiRepository;

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

  @GetMapping("/list")
  public ResponseEntity<Map> list(
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) Integer size,
      @RequestParam(required = false) String status) {
    Pageable show_data = PageRequest.of(page, size);
    Page<Transaksi> list = null;
    if (page != null && size != null && status != null) {
      list = transaksiRepository.findByStatusLike("%" + status + "%", show_data);
    } else {
      list = transaksiRepository.findAll(show_data);
    }
    return new ResponseEntity(list, new HttpHeaders(), HttpStatus.OK);
  }
}
