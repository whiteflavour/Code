package com.google.ioc;

public class Consumer {
    private int id;
    private double money;
    private Goods goods;

    public Consumer() {
    }

    public Consumer(int id, double money, Goods goods) {
        this.id = id;
        this.money = money;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public double balanceAfterBuying() {
        return money - goods.getPrice();
    }
}
