package com.indivara.paymentservice.repo;


import com.indivara.paymentservice.dto.response.PaymentWithUserAndProduct;
import com.indivara.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value = "select p.id, p.user_id as userId ,u.username ,p.product_id as productId,p2.name ,p2.price , p.amount ,p.total  from payment.payment p, product.product p2, \"user\".users u\n" +
            "WHERE p.product_id = p2.id and p.user_id =u.id",nativeQuery = true)
    List<PaymentWithUserAndProduct> findAllPaymentWithUserAndProduct();

}
