# Anti-Money Laundering (AML) Transaction Scanner

A core Java compliance engine engineered to simulate automated transaction data streams, execute programmatic financial risk scoring, and enforce strict scope encapsulation to securely flag suspicious activity.

---

## Core Engineering Foundations

This system is built from the ground up to demonstrate a solid mastery of fundamental algorithmic paradigms and low-level memory handling in Java:

* **Fintech Ingestion Simulation (Arrays & Loops):** Processes high-volume transaction records by storing payloads inside raw primitive arrays and iterating through them sequentially to mimic real-time streaming bank data.
* **Compliance Rules Engine (Conditionals & Switch Jumps):** Enforces strict regulatory thresholds by intercepting high-value transfers (e.g., transactions exceeding $10,000) and sorting geographic risks cleanly using optimized switch branches.
* **Polymorphic Reporting (Method Overloading):** Utilizes multiple signature variations of `flagTransaction()` to handle varying levels of metadata reporting context:
    * `flagTransaction(int amount)` – Basic flag based purely on transaction size thresholds.
    * `flagTransaction(int amount, String location)` – Advanced flag enriched with localized geographic risk parameters.
* **Memory Integrity (Variable Scope Boundaries):** Restricts high-sensitivity evaluation states within strict, localized block scopes to prevent memory leaks and ensure variables are not leaked globally across the system runtime.

---

## Execution & Setup

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Compilation
Compile the source code drivers directly from your root project folder:
```bash
javac Main.java TransactionScanner.java
