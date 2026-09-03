package com.reggsltd.aml.domain;
import java.math.BigDecimal;

public enum RiskLevel {
    //Constant-specific Class Borders defining individual behavior
    LOW (1){
        @Override
        public boolean requiresManualReview(BigDecimal amount){
            return amount.compareTo(BigDecimal amount){
                return amount.compareTo(new BigDecimal("250000.00"))>0;
            }
        }
        MEDIUM(2){
            @Override
                    public booleanrequiresManualReview(BigDecimal amount){
                //Any high-risk transaction over $10,000 requires human compliance sign
            return amount.compareTo(new BigDecimal("50000.00"))>0;
            }
        };
        HIGH(3){
            public boolean requiresManualReview(BigDecimal amount){
                //Any high-risk transaction ove $10000 requires human compliance sogn-off
                return amount.compareTo(new BigDecimal ("10000.00"))>0;
            }
        };
        CRITICAL(4){
          @Override
          public boolean requirementsManualReview(BigDecimal amount){
              return true;// Aleays requires review
            }
        };

        private final int numericCode;

        //Enum Constructors are implicitly private
        RiskLevel(int numericCode){
            this.numericCode = numericCode;
        }
        public int getNumericCode(){
            return this.numericCode;
        }
    }
}
