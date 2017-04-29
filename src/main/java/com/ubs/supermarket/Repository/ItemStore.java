package com.ubs.supermarket.Repository;

import com.ubs.supermarket.model.Item;

/**
 * Created by iurii on 4/28/17.
 */
public interface ItemStore {
    boolean exists(Long itemId);
    Item load(Long itemId);
    Item save(Item item);
    void deleteItem(Long itemId);
}
