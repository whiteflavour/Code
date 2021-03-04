package com.google.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * POJO 类 。copy 的书上代码来理解一下。
 *
 * @author wrox
 * @date 2021-3-4
 */
public class Ticket {
    private String customerName;
    private String subject;
    private String body;
    private Map<String, Attachment> attachments = new LinkedHashMap<>();

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

    public Attachment getAttachment(String name) {
        return attachments.get(name);
    }
    public Collection<Attachment> getAttachments() {
        return attachments.values();
    }

    public void setAttachments(Map<String, Attachment> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(Attachment attachment) {
        attachments.put(attachment.getName(), attachment);
    }

    public int getNumberOfAttachments() {
        return attachments.size();
    }
}
