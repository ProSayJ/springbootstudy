package com.prosayj.springboot.dbbackup;

import com.prosayj.springboot.constants.Constants;
import com.prosayj.springboot.utils.FileUtils;

import java.io.*;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/29 17:06
 * @since 1.0.0
 */
public class BackUp {


    /**
     * 获取mysql版本信息
     *
     * @return
     * @throws Exception
     */
    public static String getMysqlVersion() throws Exception {
        Process child = null;
        try {
            child = Runtime.getRuntime().exec("mysql --version");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return  inputStream2String(child.getErrorStream());
        return inputStream2String(child.getInputStream());
    }

    /***
     * 输入流转String
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static String inputStream2String(InputStream inputStream) throws Exception {
        String inStr;
        StringBuffer sb = new StringBuffer();
        String outStr;
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        while ((inStr = br.readLine()) != null) {
            sb.append(inStr + "\r\n");
        }
        outStr = sb.toString();
        return outStr;
    }

    /**
     * 备份数据库
     *
     * @param remoteIp       服务器ip
     * @param userName       用户名
     * @param pwd            密码
     * @param databasesNames 需要备份的数据库名称
     */
    public static void backupDB(String remoteIp, String userName, String pwd, String... databasesNames) throws Exception {
        String s = "mysqldump yinuojr_user -h 192.168.6.79  -uroot -pdb79 --default-character-set=utf8 --tables function_tree menu module page permission_item permission_item_resource resource role_resource > D:/V3.4.0-yinuojr-user-permission-new.sql";
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


        // mysqldump -u$user -p$passwd -S $sock --single-transaction --default-character-set=UTF8 --master-data=2 --set-gtid-purged=OFF --add-drop-database --triggers --routines --events -B $line  2>/dev/null > ${line}.$date.sql

        //mysql5.7
        //String command = "mysqldump -h " + remoteIp + "  -u" + userName + " -p" + pwd + " --default-character-set=utf8 --set-gtid-purged=OFF -B " + dataBasesNamesStr.toString();
        //mysql8.0
        String command = "mysqldump --column-statistics=0 -h " + remoteIp + "  -u" + userName + " -p" + pwd + " --default-character-set=utf8 --set-gtid-purged=OFF -B --databases " + dataBasesNamesStr.toString();

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
        System.out.println("备份结束，总耗时:===>" + (endTime - startTime) / 1000 / 60 + "分钟  " + (endTime - startTime) / 1000 % 60 + "秒<===");

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
     * 还原数据库：
     */
    public static void restore(String localhostIp, String userName, String pwd) {
        try {
            Runtime runtime = Runtime.getRuntime();
            String command = "mysql -h " + localhostIp + " -u" + userName + " -p" + pwd + " --default-character-set=utf8";

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
            //System.out.println("还原数据库结束，总耗时:===>" + (endTime - startTime) + "<===ms");
            System.out.println("还原数据库结束，总耗时:===>" + (endTime - startTime) / 1000 / 60 + "分钟  " + (endTime - startTime) / 1000 % 60 + "秒<===ms");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void backUpHaloIMG() throws IOException {
        FileUtils.copayBolgImgs2Forder(Constants.RESOURCE_BACKUP_PATH);
    }
}
