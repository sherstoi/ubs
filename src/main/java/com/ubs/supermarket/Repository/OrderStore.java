package com.ubs.supermarket.Repository;

import com.ubs.supermarket.model.Order;

/**
 * Created by iurii on 4/28/17.
 */
public interface OrderStore {
    void delete(Long orderId);
    Order load(Long orderId);
    Order save(Order order);
}
