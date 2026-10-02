package in.sd.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String orderId;
    private Customer customer;
    private List<OrderItem> items;
    //private OrderStatus status;

    public Order(String orderId, Customer customer) {
        if(customer == null) {
            throw new IllegalArgumentException("Customer Should not be Empty");
        }

        this.orderId = orderId;
        this.customer = customer;
    }

    public void addItem(OrderItem item) {
        if(item == null) {
            throw new IllegalArgumentException("Item should not be Empty");
        }
        items.add(item);
    }

    public double getTotalAmount() {
        double totalAmount=0;

        for(OrderItem item : items) {
            totalAmount += item.getSubTotal();
        }

        return totalAmount;
    }

}
