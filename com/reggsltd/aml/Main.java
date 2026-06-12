package com.reggsltd.aml;

public class Main {
    public static void main(String[] args) {
        // Initializing a strict Java Array of objects
        Transaction[] dailyTransactions = {
                new Transaction("1001", 450.00, "KE", "PURCHASE"),
                new Transaction("1002", 15000.00, "US", "WIRE"), // Triggers amount overload
                new Transaction("1003", 50.00, "KE", "INTERNAL_TRANSFER"), // Triggers 'continue'
                new Transaction("1004", 8000.00, "KP", "WIRE"), // Triggers compliance overload
                new Transaction("1005", 200000.00, "KY", "WIRE"), // Triggers both amount and switch notice
                new Transaction("9999", 0.00, "XX", "SYSTEM_LOCKDOWN"), // Triggers 'break'
                new Transaction("1006", 100.00, "UK", "PURCHASE") // Will not process due to break
        };

        AMLScanner scanner = new AMLScanner();
        scanner.processDailyBatch(dailyTransactions);
    }
}