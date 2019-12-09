package com.prosayj.springboot.adapter.blockchain.constant;
/**
 * @description 待提交的区块链交易数据
 * @since 1.0.0
 */
public class SignData {

	private String blob;
	private String hash;

	public String getBlob() {
		return blob;
	}

	public void setBlob(String blob) {
		this.blob = blob;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "SignData{" +
				"blob='" + blob + '\'' +
				", hash='" + hash + '\'' +
				'}';
	}
}
