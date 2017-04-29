package com.ubs.supermarket.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ubs.supermarket.exception.InvalidArrayLenthException;
import com.ubs.supermarket.model.Item;
import com.ubs.supermarket.model.Order;
import com.ubs.supermarket.service.CheckoutService;
import com.ubs.supermarket.service.ItemService;
import com.ubs.supermarket.service.OrderService;
import com.ubs.supermarket.util.Constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ubs.supermarket.util.CollectionUtil.isArrLengthIsEqual;
import static com.ubs.supermarket.util.CollectionUtil.isNullOrEmpty;

/**
 * This class represent supermarket checkout
 * service. It's <B>singleton</B> class.
 * @author Iurii
 * @Version 1.0
 */
@Singleton
public class CheckoutServiceImpl implements CheckoutService {
    private ItemService itemService;
    private OrderService orderService;

    @Inject
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Inject
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public BigDecimal calculateOneTypeItemPrice(Long itemId, int itemCount) {
        BigDecimal price = null;

        Item item = itemService.loadItem(itemId);
        if (item != null) {
            price = item.getPrice().multiply(new BigDecimal(itemCount));
            List<String> specialPriceList = parseSpecCountAndSpecPrice(item.getSpecialPrice());
            if (!isNullOrEmpty(specialPriceList)) {
                int specCount = Integer.valueOf(specialPriceList.get(Constant.Digits.ZERO));
                BigDecimal specPrice = new BigDecimal(specialPriceList.get(Constant.Digits.ONE));
                int discountCount = itemCount / specCount;
                int remainCount = itemCount % specCount;
                if (remainCount != 0) {
                    if (itemCount > specCount) {
                        price = specPrice.multiply(new BigDecimal(discountCount));
                        price = price.add(item.getPrice().multiply(new BigDecimal(remainCount)));
                    }
                } else {
                    price = specPrice.multiply(new BigDecimal(discountCount));
                }
            }
        }

        return price;
    }

    public BigDecimal calculateOrderPrice(Long orderId) {
        BigDecimal price = BigDecimal.ZERO;
        Order order = orderService.loadOrder(orderId);

        if (order != null && !isNullOrEmpty(order.getItemStorage())) {
            for (Map.Entry<Item, Integer> entry : order.getItemStorage().entrySet()) {
                price = price.add(calculateOneTypeItemPrice(entry.getKey().getItemId(), entry.getValue()));
            }
        }

        return price;
    }

    private List<String> parseSpecCountAndSpecPrice(String specCountAndPriceStr) {
        List<String> specPriceCountList = new ArrayList<>();
        if (specCountAndPriceStr != null) {
            String[] arrPriceAndCount = specCountAndPriceStr.split(Constant.ParseSymbol.ONE_SPACE_SYMBOL);
            if (isArrLengthIsEqual(arrPriceAndCount, Constant.Digits.THREE)) {
                specPriceCountList.add(arrPriceAndCount[Constant.Digits.ZERO]);
                specPriceCountList.add(arrPriceAndCount[Constant.Digits.TWO]);
            } else {
                throw new InvalidArrayLenthException("Invalid count of spaces in string: " + specCountAndPriceStr);
            }
        }

        return specPriceCountList;
    }
}
