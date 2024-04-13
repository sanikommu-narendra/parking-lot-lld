package org.example.paymentMethods;

public class CreditCard extends PaymentMethod {
    private String cardNum;
    private int cvv;

    public CreditCard(String cardNum, int cvv) {
        this.cardNum = cardNum;
        this.cvv = cvv;
    }

    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Payment by card of Rs " + amount );
        return true;
    }
}
