package com.prosayj.springboot.designmode.研磨设计模式._05_factorymethod.example1;

/**
 * 导出成数据库备份文件形式的对象
 */
public class ExportDB implements ExportFileApi {
    @Override
    public boolean export(String data) {
        //简单示意一下，这里需要操作数据库和文件
        System.out.println("导出数据" + data + "到数据库备份文件");
        return true;
    }
}

