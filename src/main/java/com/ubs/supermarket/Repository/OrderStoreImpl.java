package com.ubs.supermarket.Repository;

import com.ubs.supermarket.model.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iurii on 4/28/17.
 */
public class OrderStoreImpl implements OrderStore {
    private final Map<Long, Order> orderStorage = new HashMap<Long, Order>();

    public void delete(Long orderId) {
        orderStorage.remove(orderId);
    }

    public Order load(Long orderId) {
        return orderStorage.get(orderId);
    }

    public Order save(Order order) {
        if (order.getOrderId() == null) {
            order.setOrderId((long) (orderStorage.size() + 1));
        }
        orderStorage.put(order.getOrderId(), order);
        return order;
    }
}
