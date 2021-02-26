package com.google.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

/**
 * 发票信息
 *
 * @author Liao
 * @date 2021-2-26
 */
public class Ticket {
    private final String marketName = "Nike";
    private BigInteger id = new BigInteger("0");
    private String customerName;
    private Attachment objects;
    private Date currentTime;

    public Ticket() {}
    public Ticket(BigInteger id, String customerName, Attachment objects, Date date) {
        this.id = id;
        this.customerName = customerName;
        this.objects = objects;
        this.currentTime = date;
    }

    public String getMarketName() {
        return marketName;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<String, BigDecimal> getObjects() {
        return objects.getObjects();
    }

    public Date getDate() {
        return currentTime;
    }
}
