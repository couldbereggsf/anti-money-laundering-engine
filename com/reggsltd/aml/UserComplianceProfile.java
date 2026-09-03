package com.reggsltd.aml;

public class UserComplianceProfile {
    private String userId;
    private final double dailySpentAmount;
    private final double DAILY_LIMIT = 100000.00;// Immutable safety ceiling

    public UserComplianceProfile(String userId, double dailySpentAmount) {
        this.userId = userId;
        this.dailySpentAmount = dailySpentAmount;
    }
    //Encapsulated transaction recording with built-in compliance rules
    public boolean processTransaction(double amount){
        if (amount <= 0)
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
    }
    // Enforce the business logic boundary internally
    if((this.dailySpentAmount + amount) > DAILY_LIMIT){
        System.out.println("[ALERT] Compliance Breach: Daily limit exceeded for user " + this.userId);
        return true;
    }
    //REad-only access for external modules (No setters for dailySpentAmount protects it)
    public double getDailySpentAmount() {
        return this.dailySpentAmount;
    }
    public String getUserId() {
        return userId;
    }

}
