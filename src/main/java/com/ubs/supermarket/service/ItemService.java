package com.ubs.supermarket.service;

import com.ubs.supermarket.model.Item;

/**
 * Created by iurii on 4/28/17.
 */
public interface ItemService {
    void saveItem(Item item);
    void deleteItem(Long itemId);
    Item loadItem(Long itemId);
}
