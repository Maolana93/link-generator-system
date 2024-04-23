package com.link.generator.system.link.generator.system.service.serviceImpl;


import com.link.generator.system.link.generator.system.dto.InvoiceRequestDto;
import com.link.generator.system.link.generator.system.dto.InvoiceResponseDto;
import com.link.generator.system.link.generator.system.exception.InvalidInvoiceException;
import com.link.generator.system.link.generator.system.exception.InvoiceAlreadyExistException;
import com.link.generator.system.link.generator.system.exception.ResourceNotFoundException;
import com.link.generator.system.link.generator.system.model.Customer;
import com.link.generator.system.link.generator.system.model.Invoice;
import com.link.generator.system.link.generator.system.repository.CustomerRepository;
import com.link.generator.system.link.generator.system.repository.InvoiceRepository;
import com.link.generator.system.link.generator.system.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    @Override
    public void createInvoice(InvoiceRequestDto invoiceRequestDto) {
        boolean InvoiceExist = invoiceRepository.existsByInvoiceNumber(invoiceRequestDto.getInvoiceNumber());
        if (InvoiceExist){
            throw new InvoiceAlreadyExistException("This newInvoice cannot be saved as it already exists");
        }
        Customer existingCustomer = customerRepository.findById(invoiceRequestDto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer with customerId: " + invoiceRequestDto.getCustomerId() + " not found"));

        Invoice newInvoice = new Invoice();
        newInvoice.setInvoiceNumber(invoiceRequestDto.getInvoiceNumber());
        newInvoice.setInvoiceAmount(invoiceRequestDto.getInvoiceAmount());
        newInvoice.setCustomerId(existingCustomer.getCustomerId());
        newInvoice.setServiceProvided(invoiceRequestDto.getServiceProvided());
        newInvoice.setDealTimestamp(LocalDateTime.now());
        invoiceRepository.save(newInvoice);

    }

    @Override
    public InvoiceResponseDto getByInvoiceNo(String invoiceNumber) {
        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(()-> new InvalidInvoiceException("This invoice does not exist"));
        Customer existingCustomer = customerRepository.findById(invoice.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer with customerId not found"));
        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setInvoiceNumber(invoice.getInvoiceNumber());
        invoiceResponseDto.setInvoiceAmount(invoice.getInvoiceAmount());
        invoiceResponseDto.setCustomerName(existingCustomer.getCustomer_name());
        invoiceResponseDto.setServiceProvided(invoice.getServiceProvided());
        return invoiceResponseDto;
    }
}
