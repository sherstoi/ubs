package com.ubs.supermarket.service;

import com.google.inject.Inject;
import com.ubs.supermarket.Configure;
import com.ubs.supermarket.model.Item;
import com.ubs.supermarket.model.Order;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by iurii on 4/28/17.
 */
@RunWith(JukitoRunner.class)
public class CheckoutServiceTest {

    @Inject
    private CheckoutService checkoutService;
    @Inject
    private ItemService itemService;
    @Inject
    private OrderService orderService;

    @Test
    public void testSpecialPrice() {
        // positive case's
        Item item1 = Item.of(1L, "Shampoo", new BigDecimal("4.00"), "3 For 2");
        BigDecimal price = calcSpecialPrice(item1, 4);
        assertThat(price, is(new BigDecimal("6.00")));
        Item item2 = Item.of(2L, "Potato", new BigDecimal("3.00"), "3 For 2");
        BigDecimal price2 = calcSpecialPrice(item2, 3);
        assertThat(price2, is(new BigDecimal("2")));
        // negative case
        Item item3 = Item.of(3L, "Beer", new BigDecimal("4.00"), "3 For 2");
        BigDecimal price3 = calcSpecialPrice(item3, 3);
        assertThat(price3, not(new BigDecimal("1")));
    }

    @Test
    public void testSpecialPriceException() {
    }

    @Test
    public void testOrderPrice() {
        Item item1 = Item.of(1L, "Shampoo", new BigDecimal("4.00"), "3 For 2");
        Item item2 = Item.of(2L, "Potato", new BigDecimal("3.00"), "3 For 2");
        itemService.saveItem(item1);
        itemService.saveItem(item2);
        Map<Item, Integer> itemStoreMap = new LinkedHashMap<Item, Integer>();
        itemStoreMap.put(item1, 3);
        itemStoreMap.put(item2, 4);
        Order order = Order.of(1L, itemStoreMap);
        orderService.saveOrder(order);
        Order persOrder = orderService.loadOrder(order.getOrderId());
        BigDecimal price = checkoutService.calculateOrderPrice(order.getOrderId());
        assertThat(price, is(new BigDecimal("7.00")));
    }

    private BigDecimal calcSpecialPrice(Item item, int count) {
        itemService.saveItem(item);
        return checkoutService.calculateOneTypeItemPrice(item.getItemId(), count);
    }

    public static class CheckountServiceConfigure extends JukitoModule {
        @Override
        protected void configureTest() {
            install(new Configure());
        }
    }
}
