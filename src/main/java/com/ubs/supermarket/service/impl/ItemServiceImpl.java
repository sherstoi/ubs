package com.ubs.supermarket.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ubs.supermarket.Repository.ItemStore;
import com.ubs.supermarket.model.Item;
import com.ubs.supermarket.service.ItemService;
import com.ubs.supermarket.util.CollectionUtil;

import java.util.List;

/**
 * This class represent service for work with
 * items storage. It's <B>singleton</B> class.
 * @author Iurii
 * @Version 1.0
 */
@Singleton
public class ItemServiceImpl implements ItemService {

    private ItemStore itemStore;

    public void saveItem(Item item) {
        itemStore.save(item);
    }

    public void saveItems(List<Item> itemList) {
        if (!CollectionUtil.isNullOrEmpty(itemList)) {
            itemList.forEach(this::saveItem);
        }
    }

    public void deleteItem(Long itemId) {
        itemStore.deleteItem(itemId);
    }

    public void deleteAll() {
        itemStore.deleteAll();
    }

    public Item loadItem(Long itemId) {
        return itemStore.load(itemId);
    }

    public int cacheSize() {
        return itemStore.cacheSize();
    }

    @Inject
    public void setItemStore(ItemStore itemStore) {
        this.itemStore = itemStore;
    }
}
