package main.Entity;

import java.util.List;

public class Payment {

    private List<PaymentCard> paymentCardList;
    private Double totalAmountCharged;

    public List<PaymentCard> getPaymentCardList() {
        return paymentCardList;
    }

    public void setPaymentCardList(List<PaymentCard> paymentCardList) {
        this.paymentCardList = paymentCardList;
    }

    public Double getTotalAmountCharged() {
        return totalAmountCharged;
    }

    public void setTotalAmountCharged(Double totalAmountCharged) {
        this.totalAmountCharged = totalAmountCharged;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentCardList=" + paymentCardList +
                ", totalAmountCharged=" + totalAmountCharged +
                '}';
    }
}
