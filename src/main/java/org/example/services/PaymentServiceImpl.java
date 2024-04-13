package org.example.services;

import org.example.interfaces.PaymentService;
import org.example.paymentMethods.Cash;
import org.example.paymentMethods.CreditCard;
import org.example.paymentMethods.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void acceptCash(int amount) {
        PaymentMethod paymentMethod = new Cash();
        paymentMethod.initiatePayment(amount);
    }

    @Override
    public void acceptCard(String cardNum, int cvv, int amount) {
        PaymentMethod paymentMethod = new CreditCard(cardNum, cvv);
        paymentMethod.initiatePayment(amount);
    }
}
