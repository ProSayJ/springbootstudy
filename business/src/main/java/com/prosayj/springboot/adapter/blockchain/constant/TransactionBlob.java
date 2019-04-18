/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.adapter.blockchain.constant;

/**
 * @author wangjingru
 * @description 交易blob封装
 * @since 1.0.0
 */
public class TransactionBlob {
    private String hash;
    private String hexBlob;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHexBlob() {
        return hexBlob;
    }

    public void setHexBlob(String hexBlob) {
        this.hexBlob = hexBlob;
    }
}
