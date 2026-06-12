package com.reggsltd.aml;

public class AMLScanner {

    // A simulated high-risk threshold
    private final double HIGH_VALUE_THRESHOLD = 10000.00;

    public void processDailyBatch(Transaction[] transactions) {
        System.out.println("--- Starting Daily AML Batch Processing ---");

        // Java For-Each Loop to iterate through the Array
        for (Transaction tx : transactions) {

            // Scope: This variable only exists inside this loop iteration
            boolean requiresReview = false;

            // 1. Break/Continue Implementation
            if (tx.getTransactionType().equals("INTERNAL_TRANSFER")) {
                // We trust internal corporate transfers, skip to the next transaction to save CPU
                continue;
            }
            if (tx.getTransactionType().equals("SYSTEM_LOCKDOWN")) {
                System.out.println("CRITICAL: System lockdown transaction detected. Halting batch!");
                break; // Immediately kills the loop
            }

            // 2. If...Else Logic for amounts
            if (tx.getAmount() >= HIGH_VALUE_THRESHOLD) {
                requiresReview = true;
                // Using the overloaded method for amount violations
                flagTransaction(tx.getId(), tx.getAmount());
            }

            // 3. Switch Statement for country risk profiling
            switch (tx.getCountryCode()) {
                case "KP": // North Korea
                case "IR": // Iran
                case "SY": // Syria
                    requiresReview = true;
                    // Using the overloaded method for critical geographic violations
                    flagTransaction(tx.getId(), tx.getCountryCode(), "SANCTIONED_REGION");
                    break;
                case "KY": // Cayman Islands
                    System.out.println("Notice: Transaction " + tx.getId() + " routed through tax haven. Logging only.");
                    break;
                default:
                    // Standard region, no action needed
                    break;
            }

            if (!requiresReview) {
                System.out.println("Transaction " + tx.getId() + " CLEARED.");
            }
        }
        System.out.println("--- Batch Processing Complete ---\n");
    }

    // ==========================================
    // METHOD OVERLOADING DEMONSTRATION
    // Same method name, different parameters.
    // ==========================================

    // Overload 1: Flagged due to monetary amount
    private void flagTransaction(String id, double amount) {
        System.out.println("🚨 FLAG [AMOUNT]: TX-" + id + " exceeded threshold with $" + amount);
    }

    // Overload 2: Flagged due to geographic compliance
    private void flagTransaction(String id, String countryCode, String reason) {
        System.out.println("🚨 FLAG [COMPLIANCE]: TX-" + id + " rejected. Region: " + countryCode + " | Reason: " + reason);
    }
}