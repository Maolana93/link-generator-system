package com.link.generator.system.link.generator.system.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceResponseDto {

    private String invoiceNumber;
    private String customerName;
    private BigDecimal InvoiceAmount;
    private String serviceProvided;


}
