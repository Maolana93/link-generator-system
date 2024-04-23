package com.link.generator.system.link.generator.system.controller;


import com.link.generator.system.link.generator.system.dto.InvoiceRequestDto;
import com.link.generator.system.link.generator.system.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;
    @PostMapping("/create")
    public ResponseEntity<String> createAnInvoice(@Valid @RequestBody InvoiceRequestDto invoiceRequestDto){
        invoiceService.createInvoice(invoiceRequestDto);
        return new ResponseEntity<>("Invoice has been created and saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{invoiceNo}")
    public ResponseEntity<?> viewInvoice (@PathVariable String invoiceNo){
        return ResponseEntity.ok(invoiceService.getByInvoiceNo(invoiceNo));
    }

}
