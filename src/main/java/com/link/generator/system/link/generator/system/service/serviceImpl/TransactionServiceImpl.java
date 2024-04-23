package com.link.generator.system.link.generator.system.service.serviceImpl;


import com.link.generator.system.link.generator.system.enums.TransactionType;
import com.link.generator.system.link.generator.system.exception.AlreadyExistException;
import com.link.generator.system.link.generator.system.exception.ResourceNotFoundException;
import com.link.generator.system.link.generator.system.model.Transaction;
import com.link.generator.system.link.generator.system.repository.TransactionRepository;
import com.link.generator.system.link.generator.system.service.TransactionService;
import com.link.generator.system.link.generator.system.service.UrlBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UrlBuilderService urlBuilderService;

    @Value("${server.port}")
    private int serverPort;

    @Override
    public void saveTransaction(Transaction transaction) {
        if (transactionRepository.existsByInvoiceNumber(transaction.getInvoiceNumber())){
            throw new AlreadyExistException("This transaction with invoice number provided already exists");
        }
        transactionRepository.save(transaction);

    }
    @Override
    public Transaction viewTransaction(String invoiceNumber) {
        return transactionRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(()-> new ResourceNotFoundException("This invoice number does not exist"));
    }

    @Override
    public String generateInvoiceViewLink(String invoiceNumber) {
        String transactionCode = UUID.randomUUID().toString();
        String transactionLink = urlBuilderService.buildInvoiceViewUrl(invoiceNumber, transactionCode, serverPort);
        Transaction transaction = new Transaction(invoiceNumber, TransactionType.VIEW_INVOICE, transactionLink);
        transactionRepository.save(transaction);
        return transactionLink;
    }
    @Override
    public String generateInvoicePaymentLink(String invoiceNumber) {
        String transactionCode = UUID.randomUUID().toString();
        String paymentLink = urlBuilderService.buildInvoicePaymentUrl(invoiceNumber, transactionCode, serverPort);
        Transaction transaction = new Transaction(invoiceNumber,TransactionType.PAYMENT, paymentLink);
        transactionRepository.save(transaction);
        return paymentLink;
    }
}
