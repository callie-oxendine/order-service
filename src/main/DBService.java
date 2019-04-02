package main;

import main.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class DBService {

    //todo: once db is configured & properties have been defined in separate property file,
    // wire in server name, user/pass, connect/socket timeout values, & other necessary properties for use below

    //pseudo-code for use when constructing getOrder call to db
    private String getOrderSQL = "SELECT * FROM dbName.ORDER_TABLE WHERE orderId = {orderId}";

    public Order getOrderFromDB(Integer orderId) {
        //todo: query db to get order by orderId, map to Order obj & return it
        if (orderId == 123) return getOrderResponse(orderId);//test order
        else return null;
    }

    public void createOrderInDB(Order order) {
        //todo: query db to create order using provided Order obj
    }

    public void updateOrderInDB(Order order) {
        //todo: query db using order.getOrderId(), update order using provided Order obj
    }

    public void deleteOrderFromDB(Integer orderId) {
        //todo: query db to delete order by orderId
    }

    /* TEST ORDER CONSTRUCTED BELOW */
    public Order getOrderResponse (Integer orderId) {
        if (orderId == null) return null;

        Order order1 = new Order();
        order1.setOrderId(orderId);
        order1.setCustomer(getCustomer());
        order1.setItems(getItems());
        order1.setPayment(getPayment());
        return order1;
    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Callie");
        customer.setLastName("Oxendine");
        customer.setPhoneNumber(1234567890);
        return customer;
    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        Item item1 = new Item();
        item1.setId(850);
        item1.setDescription("Black Bean Burger");
        item1.setPrice(7.50);

        Item item2 = new Item();
        item2.setId(390);
        item2.setDescription("Cup Roasted Red Pepper Soup");
        item2.setPrice(4.95);

        items.add(item1);
        items.add(item2);
        return items;
    }

    private Payment getPayment() {
        Payment payment = new Payment();

        List<PaymentCard> paymentCardList = new ArrayList<>();
        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardholderName("Callie Oxendine");
        paymentCard.setLastFour(1234);
        paymentCard.setAmountCharged(12.45);
        paymentCardList.add(paymentCard);

        Double amt = Double.valueOf(0.0);
        for (PaymentCard aPaymentCard : paymentCardList) {
            amt += aPaymentCard.getAmountCharged();
        }

        payment.setTotalAmountCharged(amt);
        payment.setPaymentCardList(paymentCardList);
        return payment;
    }
}
