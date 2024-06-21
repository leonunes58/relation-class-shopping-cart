package entities;

import entitiesEnum.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();

    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void removeItems(OrderItem item) {
        items.remove(item);
    }
    public void addItems(OrderItem item) {
        items.add(item);
    }

    public String toString() {
        StringBuilder sb =  new StringBuilder();
        double totalPrice = 0;
        sb.append("\nOrder Moment: ").append(sdf.format(getMoment())).append("\n");
        sb.append("Order Stated: ").append(getStatus()).append("\n");
        sb.append("Order Items: ").append("\n");
        for(OrderItem item : items) {
            sb.append(item.getProduct().getName()).append(", $").append(item.getPrice()).append(", Quantity: ").append(item.getQuantity()).append(", Subtotal: $").append(item.subTotal()).append("\n");
            totalPrice += item.subTotal();
        }
        sb.append("Total Price: $").append(totalPrice).append("\n");
        return sb.toString();
    }
}
