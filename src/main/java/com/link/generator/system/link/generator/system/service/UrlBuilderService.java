package com.link.generator.system.link.generator.system.service;

public interface UrlBuilderService {

    String buildInvoiceViewUrl(String invoiceNumber, String transactionCode, int serverPort);
    String buildInvoicePaymentUrl(String invoiceNumber, String transactionCode, int serverPort);

}
