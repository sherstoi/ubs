package com.ubs.supermarket.Repository;

import com.ubs.supermarket.model.Order;

public interface OrderStore {
    void delete(Long orderId);
    void deleteAll();
    Order load(Long orderId);
    Order save(Order order);
    int getOrderCacheSize();
}
