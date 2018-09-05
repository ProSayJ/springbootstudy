package com.prosayj.springboot.designmode.研磨设计模式._05_factorymethod.example1;

public class Client {
	public static void main(String[] args) {
		ExportOperate operate = new ExportOperate();
		operate.export(2, "测试数据");
	}
}
