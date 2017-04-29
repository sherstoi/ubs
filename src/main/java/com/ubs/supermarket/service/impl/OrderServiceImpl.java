package com.ubs.supermarket.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ubs.supermarket.Repository.OrderStore;
import com.ubs.supermarket.model.Order;
import com.ubs.supermarket.service.OrderService;
import com.ubs.supermarket.util.CollectionUtil;

import java.util.List;

/**
 * This class represent service for work with
 * orders storage. It's <B>singleton</B> class.
 * @author Iurii
 * @Version 1.0
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

    public void saveOrders(List<Order> orderList) {
        if (!CollectionUtil.isNullOrEmpty(orderList)) {
            orderList.forEach(this::saveOrder);
        }
    }

    public void deleteAll() {
        orderStore.deleteAll();
    }

    public int cacheSize() {
        return orderStore.getOrderCacheSize();
    }

    @Inject
    public void setOrderStore(OrderStore orderStore) {
        this.orderStore = orderStore;
    }
}
