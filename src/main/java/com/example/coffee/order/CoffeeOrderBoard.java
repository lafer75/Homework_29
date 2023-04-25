package com.example.coffee.order;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeOrderBoard {
    private static final Logger LOGGER = Logger.getLogger(CoffeeOrderBoard.class.getName());

    private final List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        LOGGER.log(Level.INFO, "Adding order {0} for customer {1}", new Object[]{order.getOrderNumber(), order.getCustomerName()});
        orders.add(order);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            LOGGER.log(Level.INFO, "No orders to deliver");
            return null;
        }
        Order nextOrder = orders.get(0);
        LOGGER.log(Level.INFO, "Delivering order {0} for customer {1}", new Object[]{nextOrder.getOrderNumber(), nextOrder.getCustomerName()});
        orders.remove(0);
        return nextOrder;
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                LOGGER.log(Level.INFO, "Delivering order {0} for customer {1}", new Object[]{order.getOrderNumber(), order.getCustomerName()});
                orders.remove(order);
                return order;
            }
        }
        LOGGER.log(Level.INFO, "No order found with order number {0}", orderNumber);
        return null;
    }

    public void draw() {
        LOGGER.log(Level.INFO, "\n ============= \n Num | Name \n");
        for (Order order : orders) {
            LOGGER.log(Level.INFO, "{0} | {1} \n", new Object[]{order.getOrderNumber(), order.getCustomerName()});
        }
    }
}

