package org.example.paymentMethods;

public class Cash extends PaymentMethod {
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Paying by cash of Rs " + amount);
        return true;
    }
}
