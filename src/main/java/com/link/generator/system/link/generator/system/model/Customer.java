package com.link.generator.system.link.generator.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer_tb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "cus_name", nullable = false, length = 100)
    @NotNull(message = "input name")
    private String customer_name;

    @Column(name = "phone_no", nullable = false, length = 11, unique = true)
    @NotNull(message = " Enter Phone number ")
    private String phoneNo;

    @Column(nullable = false, unique = true)
    @NotNull(message = " Enter Email address")
    @Email
    private String email;

    @Column(name = "emp_address", nullable = false, length = 100)
    private String address;
}
