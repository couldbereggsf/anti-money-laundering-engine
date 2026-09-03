package com.reggsltd.aml.cli;
import com.reggsltd.aml.domain.AMLTransaction;
import java.math.BigDecimal;
import java.util.Scanner;

public class ComplianceAfminCLI {
    public static void runTerminal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===REGGS AML CLI INTERACTIVE ENGINE ===");

        while (true){
            System.out.println("\Enter Transaction ID (or 'exit' to stop) : ");
            String id = scanner.nextLine.trim();

            if ("exit".equalsIgnoreCase(id)){
                System.out.println("Enter Amount (USD: ");
                String rawAmount = scanner.nextLine().trim();

                try{
                    BigDecimal parsed = new BigDecimal(rawAmount);
                    if (parsed.compareTo(BigDecimal.ZERO) <= 0){
                        System.out.println("[ERROR] Amount must be positive. ");
                    }else {
                        amount = parsed;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] Invalid numeric format. Example input: 12500.00");
                }
            }
            System.out.println("Enter Sender country code (ISO-2): ");
            String countryCode = scanner.nextLine().trim.toUpperCase();
            //Construct transaction safely
            AMLTransaction tx = new AMLTransaction.builder()
                    .id(id)
                    .amount(amount)
                    .route(country, "US")
                    .build();
            System.out.println("[SUCCESS] Created Transaction: " + tx.getId() + "for $" + tx.getAmount());
        }
        scanner.close(); //closes the underlying stream
    }
}
