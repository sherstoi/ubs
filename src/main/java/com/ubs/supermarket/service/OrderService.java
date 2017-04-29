package com.ubs.supermarket.service;

import com.ubs.supermarket.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    void saveOrders(List<Order> orders);
    void deleteOrder(Long orderId);
    void deleteAll();
    Order loadOrder(Long orderId);
    int cacheSize();
}
