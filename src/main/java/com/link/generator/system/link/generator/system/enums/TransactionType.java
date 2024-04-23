package com.link.generator.system.link.generator.system.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum TransactionType {
    VIEW_INVOICE,

    PAYMENT;

    public static Optional<TransactionType> get(String transType){
        return Stream.of(values())
                .filter(v->v.name().equalsIgnoreCase(transType))
                .findFirst();
    }
}
