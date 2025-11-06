package ucu.lab7.payment;
import java.text.DecimalFormat;

public class CreditCardPaymentStrategy implements Payment {
    private static final DecimalFormat MONEY = new DecimalFormat("#0.00");
    private final String cardNumber;
    private final String cardOwner;

    public CreditCardPaymentStrategy(String cardNumber, String cardOwner) {
        this.cardNumber = cardNumber;
        this.cardOwner = cardOwner;
    }

    @Override
    public String pay(double amount) {
        return "Processing credit card payment from " + cardOwner +
               " (card ****" + cardNumber.substring(cardNumber.length() - 4) + 
               ") : " + MONEY.format(amount) + " UAH";
    }
}
