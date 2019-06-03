package com.prosayj.springboot.dbbackup;

import java.io.IOException;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/3 16:12
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process child = runtime.exec("mysql -uroot -proot");
    }
}
