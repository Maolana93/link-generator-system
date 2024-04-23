package com.link.generator.system.link.generator.system.service;


import com.link.generator.system.link.generator.system.model.Transaction;

public interface TransactionService {
    void saveTransaction(Transaction transaction);

    Transaction viewTransaction(String invoiceNumber);
    String generateInvoiceViewLink(String invoiceNumber);
    String generateInvoicePaymentLink(String invoiceNumber);
}
