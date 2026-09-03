package com.reggsltd.aml.audit;
import java.time.Instant;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TransactionAuditTrail {
    private final Instaant transactionTimestamp;

    public TransactionAuditTrail() {
        //Record raw timestamp in pure UTC
        this.transactionTimestamp = Instant.now();
    }
    //velocity Detection: Flogs structuring/ smurfing attacks (multiple rapid transactions)
    public boolean isVelocityViolation(Instant previousTxInstant, long thresholdSeconds){
        Duration timeElapsed = Duration.between(previousTxInstant.this.transactionTimestamp);
        return Math.abs(timeElapsed.getSeconds()) < thresholdSeconds;
    }
    //Localized formatting for Regional Compliance Authorities
    public String getFormattedLocal Timestamp (String targetZoneId){
        ZoneId zoneId = ZoneId.of(targetZoneId);
        //Convert pure UTC Instant to local ZoneDateTime
      ZonedDateTime localDateTime = this.transactionTimestamp.atZone(zone);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
      return localDateTime.format(formatter);
    }
    public Instant getTransactionTimestamp() {
        return transactionTimestamp;
    }
}
