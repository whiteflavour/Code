package com.google.model;

import java.net.InetAddress;

/**
 * 记录访问页面时的时间和离开的时间，及请求内容，IP 地址。
 *
 * @author Liao, wrox
 * @date 2021-3-9
 */
public class PageVisit {
    private long enterTime;
    private Long leftTime;
    private String request;
    private InetAddress ipAddress;

    public PageVisit() {}
    public PageVisit(long enterTime, Long leftTime, InetAddress ipAddress) {
        this.enterTime = enterTime;
        this.leftTime = leftTime;
        this.ipAddress = ipAddress;
    }

    public long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(long enterTime) {
        this.enterTime = enterTime;
    }

    public Long getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(Long leftTime) {
        this.leftTime = leftTime;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }
}
