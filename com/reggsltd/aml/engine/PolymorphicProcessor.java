package com.reggsltd.aml.engine;
import com.reggsltd.aml.domain.bankAccount;
import com.reggsltd.aml.domain.corporateAccount;

public class PolymorphicProcessor {
    //Overloading (Compile-Time Polymorphism)
    public void processFee (bankAccount account){
        account.applyMonthlySErviceFee(); //Dynamic Dispatch (Runtime Polymorphism
    }
    public void processFee(bankAccount account, boolean waiveFee){
        if (!waiveFee){
            processFee(account);
        }
    }
    public void evaluateSpecialCredit(bankAccount account){
        //Pattern Matching for instance of (Java 16+)
        if (account instanceof CorporateAccount corpAcc){
            //'corpAcc' is automatically cast and in scope here
            System.out.println("Processing credit line for corporate account: " + corpAcc.getBalance());
        }
    }
}
