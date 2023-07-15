package com.indivara.paymentservice.service.impl;

import com.indivara.paymentservice.dto.response.PaymentWithUserAndProduct;
import com.indivara.paymentservice.dto.response.ResponseMessage;
import com.indivara.paymentservice.entity.Payment;
import com.indivara.paymentservice.filter.HeaderFilter;
import com.indivara.paymentservice.repo.PaymentRepository;
import com.indivara.paymentservice.service.PaymentService;
import com.indivara.productrestclient.ProductRestClient;
import com.indivara.productrestclient.dto.response.Product;
import com.indivara.userrestclient.UserRestClient;
import com.indivara.userrestclient.dto.response.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ProductRestClient productRestClient;
    private final UserRestClient userRestClient;
    private final HeaderFilter headerFilter;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    @Override
    public List<PaymentWithUserAndProduct> findAllPaymentWithUserAndProduct() {
        log.info("hasil : "+ paymentRepository.findAllPaymentWithUserAndProduct());
        return paymentRepository.findAllPaymentWithUserAndProduct();
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
        return paymentRepository.save(savePayment);
    }

//    public User findUserById(Long id) {
//        return userRestClient.getDetailUserById(id);
//    }

    public Payment create(Payment payment){
        try{
            System.out.println("authorization : "+headerFilter.getAuthHeader());
            User responseUser = userRestClient.getDetailUserById(payment.getUserId(), headerFilter.getAuthHeader());
            Product responseProduct = productRestClient.getDetailProductById(payment.getProductId());
            if(responseUser == null) throw new NoSuchElementException("User dengan id " + payment.getUserId() + " tidak ditemukkan");
            if(responseProduct == null) throw new NoSuchElementException("Product dengan id " + payment.getProductId() + " tidak ditemukkan");
            payment.setTotal(responseProduct.getPrice() * payment.getAmount());
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return paymentRepository.save(payment);
    }

    public ResponseMessage deleteById(Long id){
        findbyId(id);
        paymentRepository.deleteById(id);
        return ResponseMessage.builder().code(201).message("Data dengan id " + id + " berhasil dihapus").build();
    }
}
