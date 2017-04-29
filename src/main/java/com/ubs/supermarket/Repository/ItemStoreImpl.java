package com.ubs.supermarket.Repository;

import com.ubs.supermarket.model.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iurii on 4/28/17.
 */
public class ItemStoreImpl implements ItemStore {
    private final Map<Long, Item> itemStorage = new HashMap<Long, Item>();

    public boolean exists(Long itemId) {
        return itemStorage.containsKey(itemId);
    }

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
}
