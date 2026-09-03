package com.reggsltd.aml.domain;
import java.math.BigDecimal;

public class TransactionRequest {
    private final String transactionId;
    private final BigDecimal amount;
    private final String currency;

    private TransactionRequest(AMLTransaction.Builder builder, String transactionId, BigDecimal amount, String currency) {
        this.transactionId = builder.transactionId;
        this.amount = builder.amount;
        this.currency = builder.currency;
    }
    public static class Builder {
        private String transactionId;
        private BigDecimal amount;
        private String currency = "USD"; // Default

        public Builder transactionId(String id) {
            this.transactionId = id;
            return this;
        }
        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }
        public TransactionRequest build() {
            if (transactionId == null || amount == null || currency == null) {
                throw new IllegalArgumentException("Missing mandatory fields. ");
            }
            return new TransactionRequest(this);
        }
    }
    public String getTransactionId() { return transactionId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
}
