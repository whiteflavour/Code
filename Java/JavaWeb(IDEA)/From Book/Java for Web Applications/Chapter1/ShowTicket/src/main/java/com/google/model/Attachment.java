package com.google.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购买的物品与价格信息
 *
 * @author Liao
 * @date 2021-2-26
 */
public class Attachment {
    private Map<String, BigDecimal> objects = new LinkedHashMap<>();
    private Map<String, Ticket> yourTicket = new LinkedHashMap<>();

    public Attachment() {}

    public Map<String, BigDecimal> getObjects() {
        return objects;
    }

    public String showObjects() {
        return objects.toString();
    }

    public void addObject(String objectName, BigDecimal price) {
        objects.put(objectName, price);
    }

    public void deleteObject(String objectName) {
        objects.remove(objectName);
    }

    public String viewObject(String objectName) {
        return "Yours: " + objectName + " Price: " + objects.get(objectName);
    }

    public Map<String, Ticket> getYourTicket() {
        return yourTicket;
    }
}
