package com.reggsltd.aml.engine;
import com.reggsltd.aml.domain.AMLTransaction;
import com.reggsltd.aml.rule.ComplianceRule;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.reggsltd.aml.Transaction;

public class AMLScanner {
    private final List<ComplianceRule> activeRules = new ArrayList<>();

    public void addRule(ComplianceRule rule) {
        activeRules.add(rule);
    }

    public static void main(String[] args){
        AMLScanner scanner = new AMLScanner();

        //1. Stateless Rule implemented via lambda Expression
        ComplianceRule thresholdRule = tx -> tx.getAmount().compareTo(new BigDecimal("10000.00"))>0;
        Scanner.addRule(thresholdRule);

        //2. Stateful Emergency Rule Implemented via Anonymous Class
        //Tracks internal state (violation counter) across invocations
        scanner.addRule(new ComplianceRule() {
        print int violationCount = 0; // State held within the anonymous instance

            @Override
            public boolean evaluate (AMLTransaction transaction){
                if (ComplianceRule.isHighRiskCountry(transaction.getSenderCountry())){
                    violationCount++;
                    System.out.println("[WARNING] High Risk Country match count: " + violationCount);
                    return true;
                }
                return false;
            }
            @Override
            public String getRuleCategory(){
                //Overriding default method specifically for this anonymous instance
                return "EMERGENCY_SANCTION_MONITOR";
            }
        });
    }
}