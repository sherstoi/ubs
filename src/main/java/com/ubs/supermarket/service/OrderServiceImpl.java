package com.ubs.supermarket.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ubs.supermarket.Repository.OrderStore;
import com.ubs.supermarket.model.Order;

/**
 * Created by iurii on 4/29/17.
 */
@Singleton
public class OrderServiceImpl implements OrderService {
    private OrderStore orderStore;

    public void deleteOrder(Long orderId) {
        orderStore.delete(orderId);
    }

    public Order loadOrder(Long orderId) {
        return orderStore.load(orderId);
    }

    public void saveOrder(Order order) {
        orderStore.save(order);
    }

    @Inject
    public void setOrderStore(OrderStore orderStore) {
        this.orderStore = orderStore;
    }
}
