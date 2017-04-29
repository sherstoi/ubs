package com.ubs.supermarket;

import com.google.inject.AbstractModule;
import com.ubs.supermarket.Repository.ItemStore;
import com.ubs.supermarket.Repository.impl.ItemStoreImpl;
import com.ubs.supermarket.Repository.OrderStore;
import com.ubs.supermarket.Repository.impl.OrderStoreImpl;
import com.ubs.supermarket.service.*;
import com.ubs.supermarket.service.impl.CheckoutServiceImpl;
import com.ubs.supermarket.service.impl.ItemServiceImpl;
import com.ubs.supermarket.service.impl.OrderServiceImpl;

/**
 * In case you have additional modules
 * please add them to this <B>configurable</B>
 * class. Guice link classes to their
 * interfaces and provide all objects
 * when needed.
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
