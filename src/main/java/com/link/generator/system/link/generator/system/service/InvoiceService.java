package com.link.generator.system.link.generator.system.service;


import com.link.generator.system.link.generator.system.dto.InvoiceRequestDto;
import com.link.generator.system.link.generator.system.dto.InvoiceResponseDto;

public interface InvoiceService {

    void createInvoice(InvoiceRequestDto invoiceRequestDto);

    InvoiceResponseDto getByInvoiceNo(String invoiceNumber);
}

