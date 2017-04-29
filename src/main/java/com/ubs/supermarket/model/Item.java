package com.ubs.supermarket.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * This class represent Item entity.
 * @Author Iurii
 * @Version 1.0
 */
public class Item {

    private Long itemId;
    private String name;
    private BigDecimal price;
    private String specialPrice;

    private Item(Long itemId, String name, BigDecimal price, String specialPrice) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.specialPrice = specialPrice;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }

    public static Item of(Long itemId, String name, BigDecimal price, String specialPrice) {
        return new Item(itemId, name, price, specialPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) &&
                Objects.equals(name, item.name) &&
                Objects.equals(price, item.price) &&
                Objects.equals(specialPrice, item.specialPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, price, specialPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", specialPrice='" + specialPrice + '\'' +
                '}';
    }
}
