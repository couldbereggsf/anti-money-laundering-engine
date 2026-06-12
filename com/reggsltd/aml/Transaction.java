package com.reggsltd.aml;

public class Transaction {
    private final String id;
    private final double amount;
    private final String countryCode;
    private final String transactionType;

    public Transaction(String id, double amount, String countryCode, String transactionType) {
        this.id = id;
        this.amount = amount;
        this.countryCode = countryCode.toUpperCase();
        this.transactionType = transactionType.toUpperCase();
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public String getCountryCode() { return countryCode; }
    public String getTransactionType() { return transactionType; }
}