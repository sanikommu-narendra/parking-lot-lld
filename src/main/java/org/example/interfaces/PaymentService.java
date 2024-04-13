package org.example.interfaces;

public interface PaymentService {
    void acceptCash(int amount);
    void acceptCard(String cardNum, int cvv, int amount);
}
