package com.google.model;

import java.math.BigDecimal;

/**
 * An easy Goods POJO.
 *
 * @author Liao
 * @date 2021-3-6
 */
public class Goods {
    private int id;
    private String name;
    private BigDecimal price;

    public Goods() {}
    public Goods(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
