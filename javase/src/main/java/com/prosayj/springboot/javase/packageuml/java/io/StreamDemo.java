package com.prosayj.springboot.javase.packageuml.java.io;

import java.io.*;

public class StreamDemo {
    public static void main(String[] args) {
        try {
            copy01(new FileInputStream("c:\\t.zip"), new FileOutputStream("d:\\t.zip"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("文件复制失败");
        }

        try {
            copy03(new FileReader("c:\\t.zip"), new FileWriter("d:\\t.zip"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件复制失败");
        }
    }

    //单个字节拷贝
    public static void copy01(FileInputStream fis, FileOutputStream fos) {
        long start = System.currentTimeMillis();
        try {
            //字节输入流,读取1个字节,输出流写1个字节
            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
        } catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("文件复制失败");
        } finally {
            closeResource(fis, fos, null, null);
        }
        long end = System.currentTimeMillis();
        System.out.println("单个字节拷贝文件耗时：" + (end - start));

    }

    //字节数组拷贝
    public static void copy02(FileInputStream fis, FileOutputStream fos) {
        long start = System.currentTimeMillis();
        try {
            //定义字节数组,缓冲
            byte[] bytes = new byte[1024 * 10];
            //读取数组,写入数组
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
                fos.write("hello world\r\n".getBytes());
            }
        } catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("文件复制失败");
        } finally {
            closeResource(fis, fos, null, null);
        }
        long end = System.currentTimeMillis();
        System.out.println("字节数组拷贝文件耗时：" + (end - start));

    }

    //字符数组拷贝：
    //字符流复制文本文件,必须文本文件，字符流查询本机默认的编码表,简体中文GBK
    public static void copy03(FileReader fr, FileWriter fw) {
        long start = System.currentTimeMillis();
        try {
            char[] cbuf = new char[1024];
            int len = 0;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
                fw.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("复制失败");
        } finally {
            closeResource(null, null, fr, fw);
        }
        long end = System.currentTimeMillis();
        System.out.println("字符数组拷贝文件耗时：" + (end - start));

    }

    /**
     * 字节流缓冲区流读写字节数组
     */
    public static void copy04(File src, File desc) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
    }

    /**
     * 字节流缓冲区流读写单个字节
     */
    public static void copy05(File src, File desc) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
        int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        bos.close();
        bis.close();
    }

    /**
     * 使用缓冲区流对象,复制文本文件
     * 数据源  BufferedReader+FileReader 读取
     * 数据目的 BufferedWriter+FileWriter 写入
     * 读取文本行, 读一行,写一行,写换行
     */
    public static void copy06(File src, File desc) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(src));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(desc));
        //读取文本行, 读一行,写一行,写换行
        String line = null;
        while ((line = bfr.readLine()) != null) {
            bfw.write(line);
            bfw.newLine();
            bfw.flush();
        }
        bfw.close();
        bfr.close();
    }

    /**
     * 转换流,InputSteamReader读取文本
     * 采用UTF-8编码表,读取文件utf
     */
    public static void readUTF() throws IOException {
        //创建自己输入流,传递文本文件
        FileInputStream fis = new FileInputStream("c:\\utf.txt");
        //创建转换流对象,构造方法中,包装字节输入流,同时写编码表名
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        char[] ch = new char[1024];
        int len = isr.read(ch);
        System.out.println(new String(ch, 0, len));
        isr.close();
    }

    /**
     * 转换流,InputSteamReader读取文本
     * 采用系统默认编码表,读取GBK文件
     */
    public static void readGBK() throws IOException {
        //创建自己输入流,传递文本文件
        FileInputStream fis = new FileInputStream("c:\\gbk.txt");
        //创建转换流对象,构造方法,包装字节输入流
        InputStreamReader isr = new InputStreamReader(fis);
        char[] ch = new char[1024];
        int len = isr.read(ch);
        System.out.println(new String(ch, 0, len));

        isr.close();
    }

    /**
     * 转换流对象OutputStreamWriter写文本
     * 采用UTF-8编码表写入
     */
    public static void writeUTF() throws IOException {
        //创建字节输出流，绑定文件
        FileOutputStream fos = new FileOutputStream("c:\\utf.txt");
        //创建转换流对象，构造方法保证字节输出流，并指定编码表是UTF-8
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write("你好");
        osw.close();
    }

    /**
     * 转换流对象 OutputStreamWriter写文本
     * 文本采用GBK的形式写入
     */
    public static void writeGBK() throws IOException {
        //创建字节输出流，绑定数据文件
        FileOutputStream fos = new FileOutputStream("c:\\gbk.txt");
        //创建转换流对象，构造方法，绑定字节输出流，使用GBK编码表
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        //转换流写数据
        osw.write("你好");

        osw.close();
    }


    public static void closeResource(FileInputStream fis, FileOutputStream fos, FileReader fr, FileWriter fw) {
        try {
            if (fos != null) {
                fos.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException("释放资源失败");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                throw new RuntimeException("释放资源失败");
            }
        }
    }

}
