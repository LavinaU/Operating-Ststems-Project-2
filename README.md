# Operating-Ststems-Project-2

This project simulates a bank environment and models tellers and customers interacting in a bank with limited resources:
Manager: only one teller can interact at a time.
Safe: up to two tellers can use the safe simultaneously.
Door: up to two customers can enter the bank simultaneously.

The bank opens after three tellers are ready. Each customer performs a transaction (deposit or withdrawal) using a teller, following proper synchronization using semaphores.

Files:
BankSimulation.java – Main class to start the simulation
Teller.java – Teller thread class
Customer.java – Customer thread class
