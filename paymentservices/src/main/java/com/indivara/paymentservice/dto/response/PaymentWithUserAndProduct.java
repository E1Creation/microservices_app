package com.indivara.paymentservice.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public interface PaymentWithUserAndProduct {
    Long getId();
    @JsonProperty("user_id")
    Long getUserId();
    String getUsername();
    @JsonProperty("product_id")
    Long getProductId();
    String getName();
    Double getPrice();
    Integer getAmount();
    Double getTotal();
}
