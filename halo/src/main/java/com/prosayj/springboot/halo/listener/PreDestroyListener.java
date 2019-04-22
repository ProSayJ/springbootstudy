package com.prosayj.springboot.halo.listener;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class PreDestroyListener implements DisposableBean, ExitCodeGenerator {
    @Override
    public void destroy() throws Exception {
        //销毁之前备份数据库和静态资源文件
        try {
            Process process = Runtime.getRuntime().exec(
                    "cmd  /c  mysqldump -u root -proot " + "数据库名称" + " > "
                            + "123" + "/" + "123" + new java.util.Date().getTime()
                            + ".sql");
            //备份的数据库名字为teacher，数据库连接和密码均为root
            System.out.println("success!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getExitCode() {
        return 5;
    }
}
