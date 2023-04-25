package com.example.coffee.order;
public class Order implements Comparable<Order> {
    private static int orderCounter = 0;
    private final int orderNumber;
    private final String customerName;

    public Order(String customerName) {
        this.orderNumber = ++orderCounter;
        this.customerName = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public int compareTo(Order otherOrder) {
        return Integer.compare(this.orderNumber, otherOrder.orderNumber);
    }
}

