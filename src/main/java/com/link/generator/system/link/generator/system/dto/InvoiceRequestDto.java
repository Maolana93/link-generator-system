package com.link.generator.system.link.generator.system.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestDto {

    private String invoiceNumber;
    private BigDecimal invoiceAmount;
    private String serviceProvided;
    private Long customerId;


}
