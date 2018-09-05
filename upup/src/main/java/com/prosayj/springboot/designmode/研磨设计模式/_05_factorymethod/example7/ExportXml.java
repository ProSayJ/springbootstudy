package com.prosayj.springboot.designmode.研磨设计模式._05_factorymethod.example7;

/**
 * 导出成xml文件的对象
 */
public class ExportXml implements ExportFileApi {
    @Override
    public boolean export(String data) {
        //简单示意一下
        System.out.println("导出数据" + data + "到XML文件");
        return true;
    }
}
