package com.google.model;

/**
 * POJO 类 。copy 的书上代码来理解一下。
 *
 * @author wrox
 * @date 2021-3-4
 */
public class Attachment {
    private String name;
    private byte[] contents;

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
