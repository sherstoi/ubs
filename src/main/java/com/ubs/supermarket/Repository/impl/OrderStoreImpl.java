package com.ubs.supermarket.Repository.impl;

import com.ubs.supermarket.Repository.OrderStore;
import com.ubs.supermarket.model.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * This class gives DAO method to work
 * with Order entity.
 * @Author Iurii
 * @Version 1.0
 */
public class OrderStoreImpl implements OrderStore {
    private final Map<Long, Order> orderStorage = new HashMap<Long, Order>();

    public void delete(Long orderId) {
        orderStorage.remove(orderId);
    }

    public void deleteAll() {orderStorage.clear();};

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

    @Override
    public int getOrderCacheSize() {
        return orderStorage.size();
    }
}
