package com.indivara.microservicesbeginner.userservices.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.indivara.microservicesbeginner.userservices.enumeration.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    private Long id;
    @Column(unique = true)
    private String nik;
    @Column(length = 50)
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String address;
    @Column(unique = true,length = 50)
    private String email;
    @Column(unique = true, length = 15)
    private String phoneNumber;


    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
