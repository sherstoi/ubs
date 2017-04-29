package com.ubs.supermarket.service;

import java.math.BigDecimal;

public interface CheckoutService {
    BigDecimal calculateOneTypeItemPrice(Long itemId, int itemCount);
    BigDecimal calculateOrderPrice(Long orderId);
}
