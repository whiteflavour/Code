package com.google.model;

/**
 * 票 POJO 类
 *
 * @author Liao
 * @date 2021-2-28
 */
public class Ticket {
    private String customerName;
    private String subject;
    private String body;

    public Ticket() {}
    public Ticket(String customerName, String subject, String body) {
        this.customerName = customerName;
        this.subject = subject;
        this.body = body;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}