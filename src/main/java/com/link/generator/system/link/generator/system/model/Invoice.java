package com.link.generator.system.link.generator.system.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "invoice_tb")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long id;

    @NotBlank(message = " Enter Invoice number ")
    @Column(name = "invoice_no", unique = true)
    private String invoiceNumber;

    @NotBlank(message = " Enter Service provided ")
    private String serviceProvided;

    @Column(name = "invoice_amount")
    @NotNull(message = " Enter Invoice amount ")
    @DecimalMin(value = "0.01", message = "Invoice amount must be greater than zero")
    private BigDecimal invoiceAmount;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name="invoice_timestamp")
    @CreationTimestamp
    private LocalDateTime dealTimestamp;

}
