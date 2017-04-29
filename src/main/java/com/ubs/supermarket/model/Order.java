package com.ubs.supermarket.model;


import java.util.Map;
import java.util.Objects;

/**
 * Created by iurii on 4/28/17.
 */
public class Order {
    private Long orderId;
    private Map<Item, Integer> itemStorage;

    private Order(Long orderId, Map<Item, Integer> itemStorage) {
        this.orderId = orderId;
        this.itemStorage = itemStorage;
    }

    public static Order of(Long orderId, Map<Item, Integer> itemStorage) {
        return new Order(orderId, itemStorage);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Map<Item, Integer> getItemStorage() {
        return itemStorage;
    }

    public void setItemStorage(Map<Item, Integer> itemStorage) {
        this.itemStorage = itemStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                '}';
    }
}
