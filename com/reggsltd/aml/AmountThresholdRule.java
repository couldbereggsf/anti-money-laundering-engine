package com.reggsltd.aml;

/*CLASS + INTERFACE IMPLEMENTATION
Implements ComplianceRule - means this class Must provide real code for isViolated() and getFlagMessage(), or it won't compile
 */
public class AmountThresholdRule implements ComplianceRule{
    //Instance field  -each Amount ThresholdRule object can have its OWN threshold value
    private  final double threshold;
//public
    public AmountThresholdRule(double threshold){
        this.threshold = threshold;
        // "this.threshold" = the field, "threshold" = the parameter
    }

    @Override
    public boolean isViolated(Transaction tx) {
         /*CONDITIONAL STATEMENT (implicit in the comparison operator)
         Returns true/false directly instead of writing:
         if (tx.getAmount() >= threshold) { return true; } else { return false; }*/
        return tx.getAmount() >= threshold;

    }

    @Override
    public String getFlagMessage(Transaction tx) {
        // STRING CONCATENATION - core Java feature for building dynamic messages

        return "FLAG [AMOUNT]: TX-" + tx.getId() + " exceeded threshold with $" + tx.getAmount();
    }

    // @Override tells the compiler: "this method must match one from the interface"
    // Helps catch typos - if it doesn't match, IntelliJ will error immediately


}
