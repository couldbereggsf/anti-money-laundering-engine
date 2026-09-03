package com.reggsltd.aml.domain;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.RoundingPolicy;
import java.util.Currency;
import java.util.Objects;

public class Transaction {
    private final String transactionId;
    private final BigDecimal amount;
    private final String currency;

    //Package-Private field: visible to classes in com.reggs.aml.domain, hidden from web controllers
    boolean isInternalTransfer;
    public Transaction(String transactionId, BigDecimal amount, String currency, boolean isInternalTransfer) {
        this.transactionId =  Objects.requireNonNull(transactionId, "Transaction ID cannot be null");
        this.currency = Objects.requireNonNull(currency, "Currency cannot be null");

        //Scale monetary values explicitly to 2 decimal places using HALF_EVEN (Banker's Rounding)
        this.amount = Objects.requireNonNull(amount, "Amount cannot be null")
                .setScale(2, RoundingMode.HALF_UP);
    }
    public String getTransactionId() {return transactionId;}
    public BigDecimal getAmount() {return amount;}
    public String getCurrency() {return currency;}
}
