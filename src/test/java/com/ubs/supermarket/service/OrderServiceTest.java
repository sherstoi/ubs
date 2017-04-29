package com.ubs.supermarket.service;

import com.google.inject.Inject;
import com.ubs.supermarket.Configure;
import com.ubs.supermarket.model.Order;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by iurii on 4/29/17.
 */

@RunWith(JukitoRunner.class)
public class OrderServiceTest {

    @Inject
    private OrderService orderService;

    @Test
    public void testSavingUniqueOrders() {
        clearOrderStorage();
        List<Order> uniqueOrdersList = buildUniqueOrdersList();
        orderService.saveOrders(uniqueOrdersList);
        uniqueOrdersList.forEach(order1 -> assertThat(orderService.loadOrder(order1.getOrderId()), is(notNullValue())));
    }

    @Test
    public void testSavingDupesOrders() {
        clearOrderStorage();
        List<Order> orderList = buildDupesOrdersList();
        orderService.saveOrders(orderList);
        assertThat(orderService.cacheSize(), is (1));
    }

    @Test
    public void testDeleteOrderById() {
        clearOrderStorage();
        List<Order> uniqueOrdersList = buildUniqueOrdersList();
        orderService.saveOrders(uniqueOrdersList);
        Order persOrder = uniqueOrdersList.get(0);
        int curSize = orderService.cacheSize();
        orderService.deleteOrder(persOrder.getOrderId());
        assertThat(orderService.cacheSize(), is (curSize - 1));
    }

    private void clearOrderStorage() {
        orderService.deleteAll();
    }

    private List<Order> buildUniqueOrdersList() {
        Order order1 = Order.of(1L, new HashMap<>());
        Order order2 = Order.of(2L, new HashMap<>());

        return Arrays.asList(order1, order2);
    }

    private List<Order> buildDupesOrdersList() {
        Order order1 = Order.of(1L, new HashMap<>());
        Order order2 = Order.of(1L, new HashMap<>());

        return Arrays.asList(order1, order2);
    }

    public static class CheckountServiceConfigure extends JukitoModule {
        @Override
        protected void configureTest() {
            install(new Configure());
        }
    }
}
