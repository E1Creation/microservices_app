package com.indivara.microservicesbeginner.userservices.dto.request;

import com.indivara.microservicesbeginner.userservices.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUser {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Gender gender;
}
