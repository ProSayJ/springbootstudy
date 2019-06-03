package com.prosayj.springboot.dbbackup;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/3 14:42
 * @since 1.0.0
 */
public class MyBlogDBBackUp {
    public static void main(String[] args) throws Exception {

        System.out.println(BackUp.getMysqlVersion());


        BackUp.backupDB("localhost", "root", "root", "blog");

//        BackUp.restore("localhost", "root", "root");
    }
}
