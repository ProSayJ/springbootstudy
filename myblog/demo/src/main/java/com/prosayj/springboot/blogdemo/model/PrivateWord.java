package com.prosayj.springboot.blogdemo.model;

import lombok.Data;

/**
 * Describe: 悄悄话
 */
@Data
public class PrivateWord {

    private int id;

    /**
     * 悄悄话内容
     */
    private String privateWord;

    /**
     * 发布者
     */
    private int publisherId;

    /**
     * 回复者
     */
    private int  replierId;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 发布时间
     */
    private String publisherDate;

    public PrivateWord() {
    }

    public PrivateWord(String privateWord, int publisherId, String publisherDate) {
        this.privateWord = privateWord;
        this.publisherId = publisherId;
        this.publisherDate = publisherDate;
    }
}
