package com.reggsltd.aml;

import java.util.ArrayList; // Resizable array - unlike Transaction[], it can grow/shrink
import java.util.List;      // The interface type we program against (best practice)

public class AMLScanner {

    // COLLECTIONS + INTERFACE TYPE AS A VARIABLE TYPE
    // "List<ComplianceRule>" means: a list that can hold ANY object
    // as long as that object implements ComplianceRule.
    // This is what lets us add new rule types later without touching this class.
    private final List<ComplianceRule> rules = new ArrayList<>();

    // CONSTRUCTOR - runs once when "new AMLScanner()" is called in Main.
    // Sets up the default rules the scanner will check every transaction against.
    public AMLScanner() {
        rules.add(new AmountThresholdRule(10000.00));
        rules.add(new SanctionedRegionRule());
        // To add a brand-new rule in future: write a new class implementing
        // ComplianceRule, then add ONE line here. No other code changes needed.
    }

    public void processDailyBatch(Transaction[] transactions) {
        System.out.println("--- Starting Daily AML Batch Processing ---");

        // FOR-EACH LOOP - iterates through the raw Transaction[] array
        for (Transaction tx : transactions) {

            // IF STATEMENT + .equals() for STRING COMPARISON
            // (never use "==" for Strings in Java - it compares memory references, not content)
            if (tx.getTransactionType().equals("INTERNAL_TRANSFER")) {
                // CONTINUE - skips the rest of THIS iteration only, loop keeps going
                continue;
            }

            if (tx.getTransactionType().equals("SYSTEM_LOCKDOWN")) {
                System.out.println("CRITICAL: System lockdown transaction detected. Halting batch!");
                // BREAK - exits the entire loop immediately, no more transactions processed
                break;
            }

            // LOCAL VARIABLE with LIMITED SCOPE
            // "requiresReview" only exists inside this one loop iteration -
            // it's recreated fresh for every transaction, preventing state leaking between them.
            boolean requiresReview = false;

            // NESTED LOOP + POLYMORPHISM
            // For every transaction, check it against EVERY rule in the list.
            // "ComplianceRule rule" - the loop variable's declared TYPE is the interface,
            // but at runtime it could be an AmountThresholdRule OR a SanctionedRegionRule.
            // Java automatically calls the correct class's version of isViolated() -
            // this dynamic method dispatch IS polymorphism in action.
            for (ComplianceRule rule : rules) {
                if (rule.isViolated(tx)) {
                    requiresReview = true;
                    System.out.println(rule.getFlagMessage(tx));
                }
            }

            // IF...ELSE (via negation) - only prints CLEARED if nothing flagged it above
            if (!requiresReview) {
                System.out.println("Transaction " + tx.getId() + " CLEARED.");
            }
        }
        System.out.println("--- Batch Processing Complete ---\n");
    }
}