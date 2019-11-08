package com.prosayj.springboot.dbbackup;

import com.prosayj.springboot.constants.Constants;
import com.prosayj.springboot.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/29 17:06
 * @since 1.0.0
 */
public class BackUp {

    private static final Logger logger = LoggerFactory.getLogger(BackUp.class);

    /**
     * 获取mysql版本信息
     *
     * @return
     * @throws Exception
     */
    public static String getMysqlVersion() {
        Process child = null;
        try {
            child = Runtime.getRuntime().exec("mysql --version");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return  inputStream2String(child.getErrorStream());
        String result = null;
        try {
            result = inputStream2String(child.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
        //String s = "mysqldump yinuojr_user -h 192.168.6.79  -uroot -pdb79 --default-character-set=utf8 --tables function_tree menu module page permission_item permission_item_resource resource role_resource > D:/V3.4.0-yinuojr-user-permission-new.sql";
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
        String command = "";
        String mysqlVersion = BackUp.getMysqlVersion();
        if (mysqlVersion.contains("5.")) {
            //mysql5.7
            command = "mysqldump  -h " + remoteIp + "  -u" + userName + " -p" + pwd + " --set-gtid-purged=OFF -B --databases " + dataBasesNamesStr.toString();
        } else if (mysqlVersion.contains("8.")) {
            //mysql8.0
            command = "mysqldump --column-statistics=0 -h " + remoteIp + "  -u" + userName + " -p" + pwd + " --default-character-set=utf8 --set-gtid-purged=OFF -B --databases " + dataBasesNamesStr.toString();
        } else {
            logger.error("数据库版本错误：版本是：{}", mysqlVersion);
        }


        long startTime = System.currentTimeMillis();
        logger.info("备份数据库开始，客户端版本：{}，备份sql脚本:{}", mysqlVersion, command);


        br = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream(), "utf-8"));
        while ((inStr = br.readLine()) != null) {
            sb.append(inStr + "\r\n");
        }
        outStr = sb.toString();

        writer.write(outStr);
        writer.flush();
        long endTime = System.currentTimeMillis();
        logger.info("备份数据库结束，客户端版本：{}，备份sql脚本:{}，耗时：{}", mysqlVersion, command, (endTime - startTime) / 1000 / 60 + "分钟  " + (endTime - startTime) / 1000 % 60 + "秒");

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


            logger.info("还原数据库开始，客户端版本：{}，还原sql脚本:{}", BackUp.getMysqlVersion(), command);
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
            logger.info("还原数据库结束，客户端版本：{}，还原sql脚本:{}，总耗时{}", BackUp.getMysqlVersion(), command, (endTime - startTime) / 1000 / 60 + "分钟  " + (endTime - startTime) / 1000 % 60 + "秒");
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
