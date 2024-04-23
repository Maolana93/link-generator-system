package com.link.generator.system.link.generator.system.model;


import com.link.generator.system.link.generator.system.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "transaction_tb")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    private String invoiceNumber;

    @Column(name = "trans_type", nullable = false)
    @NotNull(message = "Transaction type number is required")
    @Enumerated(EnumType.STRING)
    private TransactionType typeOfTrans;

    private String transactionLink;

    public Transaction(String invoiceNumber, TransactionType transactionType, String paymentLink) {
    }
}
