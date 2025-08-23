package help;

public class Card {
    private String cardHolder;
    private double cardBalance;
    private long cardNumber;

    public Card() {
    }

    public Card(String cardHolder, double cardBalance, long cardNumber) {
        this.cardHolder = cardHolder;
        this.cardBalance = cardBalance;
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
