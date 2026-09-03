package com.reggsltd.aml.engine;
import com.reggsltd.aml.domain.TransactionRequest;
import com.reggsltd.aml.rule.ComplianceRule;
import java.math.BigDecimal;
import java.util.function.BiFunction;

public class DynamicRuleEngine {
    public void executeRules() {
        BigDecimal localThreshold = new BigDecimal("1000.00");
        //Effectively Final

        //1. Anonymous Class (Stateful, generates distinct .class file, 'this' refers to rule instance)
        ComplianceRule statefulRule = new ComplianceRule() {
            private int violationCounter = 0;

            @Override
            public boolean evaluate(TransactionRequest tx) {
                if (tx.getAmount().compareTo(localThreshold) > 0) {
                    violationCounter++;
                    return true;
                }
                return false;
            }
        };
        //2. Lambda Expression (Stateless, lightweight invokedynamic instruction, 'this' refers to DynamicRuleEngine)
        ComplianceRule lambdaRule = tx -> tx.getAmount().compareTo(localThreshold) > 0;
    }
}
