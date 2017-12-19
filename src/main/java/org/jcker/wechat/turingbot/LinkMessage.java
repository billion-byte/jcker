package org.jcker.wechat.turingbot;

/**
 * Created by Alan Turing on 2017/6/15.
 */
public class LinkMessage {
    private String code;
    private String text;
    private String url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
