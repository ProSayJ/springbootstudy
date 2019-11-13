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
        /**
         * 查看GTID:
         * show variables like '%ENFORCE_GTID_CONSISTENCY%';
         *
         * 远程和本地的GTID设置需要一致
         *
         */

        BackUp.backupDB("192.168.6.79",
                "root",
                "db79","bunuo","yinuojr_user",
 //               "bunuo",
//                "yinuojr_user",
                "yinuojr_certification",
                "yinuojr_settlement",
                "yinuojr_pay",
                "yinuojr_tbank",
                "yinuojr_oss",
                "yinuojr_auth",
                "yinuojr_ops",
                "yinuojr_metadata",
                "yinuojr_csf"
        );

        BackUp.restore("localhost", "root", "root");
    }
}
