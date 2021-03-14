package com.google.model;

/**
 * Attachment POJO.
 *
 * @author Liao
 * @date 2021-3-14
 */
public class Attachment {
    private String name;
    private byte[] contents;

    public Attachment() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContents() {
        return contents;
    }
    public void setContents(byte[] contents) {
        this.contents = contents;
    }
}
