package org.jcker.wechat.entity.web;


/**
 * Created by Alan Turing on 2017/6/29.
 */
public class Message {
    private String id;
    private String text;

    public Message() {
    }

    public Message(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
