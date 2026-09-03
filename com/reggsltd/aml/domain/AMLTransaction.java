package com.reggsltd.aml.domain;
import java.math.BigDecimal;
import java.time.Instant;

public class AMLTransaction {
    private final String id;
    private final BigDecimal amount;
    private final StringreceiverCountry;
    private final Instant timestamp;

    //Private constructor enforces construction strictly via the Static Inner Builder
    private AMLTransaction(Builder builder){
        this.id = builder.id;
        this.amount = builder.amount;
        this.senderCountry = builder.receiverCountry;
        this.timestamp = builder.timestamp;
    }

    //1.Static Nested Class: Independent of outer instance memory
    public static class Builder {
        private String id;
        private BigDecimal amount;
        private String senderCountry;
        private String receiverCountry;
        private Instant timestamp = Instant.now();

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder route(String senderCountry, String receiverCountry) {
            this.senderCountry = senderCountry;
            this.receiverCountry = receiverCountry;
            return this;
        }
        public AMLTransaction build() {
            //validation before instantiation
            if (id == null || amount == null || senderCountry == null || receiverCountry == null) {
                throw new IllegalArgumentException("Missing mandatory fields for AMLTransaction. ");
            }
            return new AMLTransaction(this);
        }
    }
    //2. Member Inner Class: Has direct access to outer instances private fields
    public class AuditMetadata{
        public String generateLogEntry(){
            //Directly accesses 'id', 'amount', and 'sendeCountry' from AMLTransaction.this
            return String.format("[AUDIT] TX #%s | Amount: $%s | Origin: %s" id, amount, senderCountry);
        }
    }
    public String getId() {return id;}
    public BigDecimal getAmount() {return amount;}
    public String getSenderCountry() {return senderCountry;}
    public String getReceiverCouuntry() {return receiverCountry;}
}
