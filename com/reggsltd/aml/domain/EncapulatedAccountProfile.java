package com.reggsltd.aml.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public class EncapulatedAccountProfile {
    private final String accountId;
    private final BigDecimal balance;
    private final List<String> auditLogs; //Mutable object reference

    public EncapulatedAccountProfile(String accountId, BigDecimal balance, List<String> auditLogs) {
        this.accountId = Objects.requireNonNull(accountId, "Account ID cannot be null");
        setBalance(initialBalance);
        this.auditLogs = new ArrayList<>();
    }

    public void setBalance(BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be null or negative");
        }
        this.balance = balance;
    }

    public void assAuditEntry(String entry){
        this.auditLogs.add(System.currentTimeMillis() + ":" + entry);
        // Defensive copying: Exposes unmodifiable view to prevent external mutation
        public List<String>getAuditLogs(){
            return Collections.unmofiableList(this.auditLogs);
        }
        public String getAccountId() { return accountId; }
        public bigDecimal getBalance() { return balance; }
    }

    //Modern Immutable Equivalent using Java Records
    record AccountProfileDTO(String accountId, BigDecimal balance) {
        public AccountProfileDTO(String accountId, BigDecimal balance) {
            if (balance.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Balance cannot be null negative");
            }
        }
    }
}
