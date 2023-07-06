package com.indivara.paymentservice.service;


import com.indivara.paymentservice.entity.Payment;
import com.indivara.paymentservice.repo.PaymentRepository;
import com.indivara.paymentservice.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Payment findbyId(Long id){
        return paymentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Payment dengan id : "+ id + " tidak ditemukkan"));
    }

    public Payment update(Long id, Payment payment){
        Payment savePayment = findbyId(id);
        if(payment.getUserId() != null) savePayment.setUserId(payment.getUserId());
        if(payment.getProductId() != null) savePayment.setProductId(payment.getProductId());
        if(payment.getAmount() != null) savePayment.setAmount(payment.getAmount());
        if(payment.getTotal() != null) savePayment.setTotal(payment.getTotal());
        return paymentRepository.save(payment);
    }

    public Payment create(Payment payment){
        return paymentRepository.save(payment);
    }

    public ResponseMessage deleteById(Long id){
        findbyId(id);
        paymentRepository.deleteById(id);
        return ResponseMessage.builder().code(201).message("Data dengan id " + id + " berhasil dihapus").build();
    }
}
