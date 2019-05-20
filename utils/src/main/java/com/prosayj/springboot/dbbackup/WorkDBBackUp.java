package com.prosayj.springboot.dbbackup;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/16 11:55
 * @since 1.0.0
 */
public class WorkDBBackUp {
    public static void main(String[] args) throws Exception {

        System.out.println(BackUp.getMysqlVersion());


        BackUp.backupDB("192.168.6.79",
                "root",
                "db79",
                "bunuo",
                "yinuojr_user",
                "yinuojr_certification",
                "yinuojr_settlement",
                "yinuojr_pay",
                "yinuojr_tbank",
                "yinuojr_oss",
                "yinuojr_auth",
                "yinuojr_ops",
                "yinuojr_metadata");

        BackUp.restore("localhost", "root", "root");
    }
}