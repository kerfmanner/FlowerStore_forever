package ucu.lab7.payment;

import java.text.DecimalFormat;

public class PayPalPaymentStrategy implements Payment {
    private static final DecimalFormat MONEY = new DecimalFormat("#0.00");
    private final String accountEmail;

    public PayPalPaymentStrategy(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public String pay(double amount) {
        return "Processing PayPal payment for " + accountEmail + " : " + MONEY.format(amount) + " UAH";
    }
}
