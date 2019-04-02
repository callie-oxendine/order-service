package main.Entity;

public class PaymentCard {

    private String cardholderName;
    private Integer lastFour;
    private Double amountCharged;

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public Integer getLastFour() {
        return lastFour;
    }

    public void setLastFour(Integer lastFour) {
        this.lastFour = lastFour;
    }

    public Double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(Double amountCharged) {
        this.amountCharged = amountCharged;
    }

    @Override
    public String toString() {
        return "PaymentCard{" +
                "cardholderName='" + cardholderName + '\'' +
                ", lastFour=" + lastFour +
                ", amountCharged=" + amountCharged +
                '}';
    }
}
