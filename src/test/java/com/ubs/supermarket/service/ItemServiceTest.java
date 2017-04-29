package com.ubs.supermarket.service;

import com.google.inject.Inject;
import com.ubs.supermarket.Configure;
import com.ubs.supermarket.model.Item;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by iurii on 4/28/17.
 */
@RunWith(JukitoRunner.class)
public class ItemServiceTest {

    @Inject
    private ItemService itemService;

    @Test
    public void testSavingUniqueItems() {
        clearItemStorage();
        List<Item> uniqueItemsList = buildUniqueItemsList();
        itemService.saveItems(uniqueItemsList);
        uniqueItemsList.forEach(item1 -> assertThat(itemService.loadItem(item1.getItemId()), is(notNullValue())));
    }

    @Test
    public void testSavingDupesOrders() {
        clearItemStorage();
        List<Item> itemList = buildDupesItemsList();
        itemService.saveItems(itemList);
        assertThat(itemService.cacheSize(), is (1));
    }

    @Test
    public void testDeleteOrderById() {
        clearItemStorage();
        List<Item> uniqueItemsList = buildUniqueItemsList();
        itemService.saveItems(uniqueItemsList);
        Item persOrder = uniqueItemsList.get(0);
        int curSize = itemService.cacheSize();
        itemService.deleteItem(persOrder.getItemId());
        assertThat(itemService.cacheSize(), is (curSize - 1));
    }

    private void clearItemStorage() {
        itemService.deleteAll();
    }

    private List<Item> buildUniqueItemsList() {
        Item item1 = Item.of(1L, "Shampoo", new BigDecimal("1.00"), null);
        Item item2 = Item.of(2L, "Beer", new BigDecimal("2.00"), null);

        return Arrays.asList(item1, item2);
    }

    private List<Item> buildDupesItemsList() {
        Item item1 = Item.of(1L, "Shampoo", new BigDecimal("1.00"), null);
        Item item2 = Item.of(1L, "Shampoo", new BigDecimal("1.00"), null);

        return Arrays.asList(item1, item2);
    }

    public static class CheckountServiceConfigure extends JukitoModule {
        @Override
        protected void configureTest() {
            install(new Configure());
        }
    }}
