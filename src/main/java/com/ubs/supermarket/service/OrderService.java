package com.ubs.supermarket.service;

import com.ubs.supermarket.model.Order;

/**
 * Created by iurii on 4/29/17.
 */
public interface OrderService {
    void saveOrder(Order item);
    void deleteOrder(Long orderId);
    Order loadOrder(Long orderId);
}
