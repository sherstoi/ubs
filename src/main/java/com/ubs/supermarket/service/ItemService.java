package com.ubs.supermarket.service;

import com.ubs.supermarket.model.Item;

import java.util.List;

public interface ItemService {
    void saveItem(Item item);
    void saveItems(List<Item> items);
    void deleteItem(Long itemId);
    void deleteAll();
    Item loadItem(Long itemId);
    int cacheSize();
}
