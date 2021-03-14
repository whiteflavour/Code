package com.google.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Ticket POJO. Supply customer name, subject, body and attachments.
 *
 * @author Liao
 * @date 2021-3-14
 */
public class Ticket {
    private String customerName;
    private String subject;
    private String body;
    private Map<String, Attachment> attachments = new LinkedHashMap<>();

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

    public Collection<Attachment> getAttachments() {
        return attachments.values();
    }
    public void addAttachment(Attachment attachment) {
        attachments.put(attachment.getName(), attachment);
    }

    public Attachment getAttachment(String attachmentName) {
        return attachments.get(attachmentName);
    }
}
