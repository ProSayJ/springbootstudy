package com.prosayj.springboot.dbbackup;

import java.io.*;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/29 17:06
 * @since 1.0.0
 */
public class DbBackUp {
    public static void main(String[] args) throws Exception {

        backup("192.168.6.79",
                "root",
                "db79",
                /*"bunuo",
                "yinuojr_user",
                "yinuojr_certification",
                "yinuojr_settlement",
                "yinuojr_pay",
                "yinuojr_tbank",
                "yinuojr_oss",
                "yinuojr_auth",
                "yinuojr_ops",*/
                "yinuojr_metadata");

        restore("localhost", "root", "root");
    }

    /**
     * 备份
     *
     * @param remoteIp       服务器ip
     * @param userName       用户名
     * @param pwd            密码
     * @param databasesNames 需要备份的数据库名称
     */
    public static void backup(String remoteIp, String userName, String pwd, String... databasesNames) throws Exception {
        StringBuffer dataBasesNamesStr = new StringBuffer();
        String inStr;
        StringBuffer sb = new StringBuffer();
        String outStr;
        BufferedReader br = null;
        OutputStreamWriter writer = null;
        FileOutputStream fout = null;

        for (String databasesName : databasesNames) {
            dataBasesNamesStr.append(databasesName).append(" ");
        }
        fout = new FileOutputStream("D:\\all.sql");
        writer = new OutputStreamWriter(fout, "utf-8");

        //mysql5.7
        //String command = "mysqldump -h " + remoteIp + "  -u" + userName + " -p" + pwd + " -B  " + dataBasesNamesStr.toString();
        //mysql8.0
        String command = "mysqldump --column-statistics=0 -h " + remoteIp + "  -u" + userName + " -p" + pwd + " --default-character-set=utf8 --databases " + dataBasesNamesStr.toString();

        long startTime = System.currentTimeMillis();
        System.out.println("开始执行备份数据库sql语句：" + command);



        Process child = Runtime.getRuntime().exec(command);

        br = new BufferedReader(new InputStreamReader(child.getInputStream(), "utf-8"));
        while ((inStr = br.readLine()) != null) {
            sb.append(inStr + "\r\n");
        }
        outStr = sb.toString();

        writer.write(outStr);
        writer.flush();
        long endTime = System.currentTimeMillis();
        System.out.println("备份结束，总耗时:===>" + (endTime - startTime) + "<===ms");

        try {

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (fout != null) {
                    fout.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 还原
     */
    public static void restore(String remoteIp, String userName, String pwd) {
        try {
            Runtime runtime = Runtime.getRuntime();
            String command = "mysql -h " + remoteIp + " -u" + userName + " -p" + pwd + " --default-character-set=utf8 ";

            System.out.println("开始执行还原数据库sql文件：" + command);
            long startTime = System.currentTimeMillis();

            Process process = runtime.exec(command);

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\all.sql"), "utf-8"));
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\r\n");
            }
            OutputStreamWriter writer = new OutputStreamWriter(process.getOutputStream(), "utf-8");
            writer.write(sb.toString());
            writer.flush();
            br.close();
            writer.close();


            long endTime = System.currentTimeMillis();
            System.out.println("还原数据库结束，总耗时:===>" + (endTime - startTime) + "<===ms");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
