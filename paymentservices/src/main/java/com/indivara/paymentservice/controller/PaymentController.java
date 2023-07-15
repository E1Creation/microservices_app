package com.indivara.paymentservice.controller;


import com.indivara.paymentservice.dto.response.PaymentWithUserAndProduct;
import com.indivara.paymentservice.entity.Payment;
import com.indivara.paymentservice.dto.response.ResponseMessage;
import com.indivara.paymentservice.service.PaymentService;
import com.indivara.userrestclient.dto.response.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        return new ResponseEntity<>(paymentService.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("/paymentwithuserandproduct")
    public ResponseEntity<List<PaymentWithUserAndProduct>> findAllPaymentWithUserAndProduct(){
        return new ResponseEntity<>(paymentService.findAllPaymentWithUserAndProduct(), HttpStatus.OK);
    }

//    @GetMapping("/user/{id}")
//    public ResponseEntity<User> findUserById(@PathVariable Long id){
//        return  new ResponseEntity<>(paymentService.findUserById(id), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment, @RequestHeader("Authorization") String autHeader){
        return new ResponseEntity<>(paymentService.create(payment, autHeader),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.update(id, payment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        return new ResponseEntity<>(paymentService.deleteById(id), HttpStatus.CREATED);
    }
}
