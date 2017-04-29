package com.ubs.supermarket;

import com.google.inject.AbstractModule;
import com.ubs.supermarket.Repository.ItemStore;
import com.ubs.supermarket.Repository.ItemStoreImpl;
import com.ubs.supermarket.Repository.OrderStore;
import com.ubs.supermarket.Repository.OrderStoreImpl;
import com.ubs.supermarket.service.*;

/**
 * Created by iurii on 4/28/17.
 */
public class Configure extends AbstractModule {

    @Override
    protected void configure() {
        bind(ItemStore.class).to(ItemStoreImpl.class);
        bind(ItemService.class).to(ItemServiceImpl.class);
        bind(OrderStore.class).to(OrderStoreImpl.class);
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(CheckoutService.class).to(CheckoutServiceImpl.class);
    }
}
