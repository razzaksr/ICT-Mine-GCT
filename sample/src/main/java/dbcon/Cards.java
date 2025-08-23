package dbcon;

public class Cards {
    private String cardHolder;
    private double cardBalance;
    private long cardNumber;
    private String pan;

    @Override
    public String toString() {
        return "Cards{" +
                "cardHolder='" + cardHolder + '\'' +
                ", cardBalance=" + cardBalance +
                ", cardNumber=" + cardNumber +
                ", pan='" + pan + '\'' +
                '}';
    }

    public Cards() {
    }

    public Cards(String cardHolder, double cardBalance, long cardNumber, String pan) {
        this.cardHolder = cardHolder;
        this.cardBalance = cardBalance;
        this.cardNumber = cardNumber;
        this.pan = pan;
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

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
