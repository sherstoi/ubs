package com.ubs.supermarket.Repository;

import com.ubs.supermarket.model.Item;

public interface ItemStore {
    Item load(Long itemId);
    Item save(Item item);
    void deleteItem(Long itemId);
    void deleteAll();
    int cacheSize();
}
