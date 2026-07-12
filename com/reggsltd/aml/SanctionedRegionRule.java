package com.reggsltd.aml;

import java.util.Set; //Need this import to use the Set collection type

/*CLASS + INTERFACE IMPLEMENTATION
Same interface as AmountThresholdRule, but completely different internal logic
This is POLYMORPHISM: AMLScanner can call isViolated() on ANY rule
without knowing or caring which class it actually is.*/


public class SanctionedRegionRule  implements  ComplianceRule{

    /*COLLECTIONS (Set) - replaces the old switch/case list of countries.
     Set.of(...) creates an IMMUTABLE set (can't be changed after creation).
     A Set has no duplicates and offers fast "contains" lookups.*/

    private final Set<String> sanctionedCountries = Set.of("KP", "IR", "SY");

    @Override
    public boolean isViolated(Transaction tx){
       /* CONDITIONAL LOGIC via Set.contains() instead of multiple "==" or switch cases.
         This one line replaces what used to be 3 "case" labels in the old switch statement.*/

        return sanctionedCountries.contains(tx.getCountryCode());

    }

    @Override
    public String getFlagMessage(Transaction tx) {
        return "FLAG [COMPLIANCE]: TX-" + tx.getId() +
                " rejected. Region: " + tx.getCountryCode() +
                " | Reason: SANCTIONED_REGION";
    }


}
