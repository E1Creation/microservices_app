package com.indivara.paymentservice.service;

import com.indivara.paymentservice.dto.response.PaymentWithUserAndProduct;
import com.indivara.paymentservice.entity.Payment;
import com.indivara.paymentservice.dto.response.ResponseMessage;
import com.indivara.userrestclient.dto.response.User;

import java.util.List;

public interface PaymentService {
     List<Payment> findAll();
     List<PaymentWithUserAndProduct> findAllPaymentWithUserAndProduct();
     Payment findbyId(Long id);
     Payment update(Long id, Payment payment);
     Payment create(Payment payment, String authHeader);
     ResponseMessage deleteById(Long id);
}
