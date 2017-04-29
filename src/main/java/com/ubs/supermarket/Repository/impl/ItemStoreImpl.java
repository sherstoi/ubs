package com.ubs.supermarket.Repository.impl;

import com.ubs.supermarket.Repository.ItemStore;
import com.ubs.supermarket.model.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * This class gives DAO methods to
 * work with Item storage.
 * @Author Iurii
 * @Version 1.0
 */
public class ItemStoreImpl implements ItemStore {
    private final Map<Long, Item> itemStorage = new HashMap<Long, Item>();

    public Item load(Long itemId) {
        return itemStorage.get(itemId);
    }

    public Item save(Item item) {
        if (item.getItemId() == null) {
            item.setItemId((long) (itemStorage.size() + 1));
        }
        itemStorage.put(item.getItemId(), item);
        return item;
    }

    public void deleteItem(Long itemId) {
        itemStorage.remove(itemId);
    }

    public void deleteAll() { itemStorage.clear();}

    public int cacheSize() {
        return itemStorage.size();
    }
}
