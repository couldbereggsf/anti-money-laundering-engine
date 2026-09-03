package com.reggsltd.aml.domain;
import java.math.BigDecimal;

//Sealed class restricting subclassing strictly to corporate and retail accounts

public class bankAccount(String accountNumber, BigDecimal initialDeposit) {
    public bankAccount(String accountNumber, BigDecimal initialDeposit) {

    }this.accountNumber=accountNumber;
    this.balance =initialDeposit;
}
        public abstract void applyMonthlyServiceFee();
public final void deposit(BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) < 0) throw new illegalArguementException("Inavalid deposit");
    this.balance = this.balance.add(amount);
        public BigDecimal getBalance() { return balance;}
    }
public final class corporateAccount extends bankAccount {
    private final BigDecimal creditLine;
    public corporateAccount(String accountNumber, BigDecimal initialDeposit, BigDecimal creditLine) {
        super (accountNumber, initialDeposit);
        this.creditLine = creditLine;
    }

    @Override
    public void applyMonthlyServiceFee(){
        this.balance = this.balance.subtract(new BigDecimal ("50.00"));
    }
}
public final class retailAccount extends bankAccount {
    public retailAccount(String accountNumber, BigDecimal initialDeposit, BigDecimal creditLine) {
        super (accountNumber, initialDeposit);
    }

    @Override
    public void applyMonthlyServiceFee(){
        this.balance = this.balance.subtract(new BigDecimal("10.00"));
    }
}

