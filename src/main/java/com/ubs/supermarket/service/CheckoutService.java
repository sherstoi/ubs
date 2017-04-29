package com.ubs.supermarket.service;

import java.math.BigDecimal;

/**
 * Created by iurii on 4/28/17.
 */
public interface CheckoutService {
    BigDecimal calculateOneTypeItemPrice(Long itemId, int itemCount);
    BigDecimal calculateOrderPrice(Long orderId);
}
