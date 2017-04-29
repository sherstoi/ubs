package com.ubs.supermarket.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ubs.supermarket.Repository.ItemStore;
import com.ubs.supermarket.model.Item;

/**
 * Created by iurii on 4/28/17.
 */
@Singleton
public class ItemServiceImpl implements ItemService {

    private ItemStore itemStore;

    public void saveItem(Item item) {
        itemStore.save(item);
    }

    public void deleteItem(Long itemId) {
        itemStore.deleteItem(itemId);
    }

    public Item loadItem(Long itemId) {
        return itemStore.load(itemId);
    }

    @Inject
    public void setItemStore(ItemStore itemStore) {
        this.itemStore = itemStore;
    }
}
