package com.reggsltd.aml;
/*INTERFACE (Abstraction)
An interface defines WHAT a class must do, not HOW.
A contract -any class that implements this MUST provide these two methods .
This treats all rules the same way , even though they check very different
 */

public interface ComplianceRule {

    //Every rule must be able to answer :"does this transaction violate me ?"
    boolean isViolated(Transaction tx);

    //Every rule must be able to explain itself when it fires
    String getFlagMessage(Transaction tx);
}
