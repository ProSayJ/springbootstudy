package com.prosayj.springboot.javase.packageuml.java.io;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) {
        //获取与系统有关的路径分隔符，windowns是；Linux :
        System.out.println(File.pathSeparator);

        //获取系统有关的默认名称分隔符，向右 \  目录名称分割  Linux /
        System.out.println(File.separator);

        /**
         * File常用的三个构造方法
         */
        //传递路径,传递File类型父路径,字符串子路径,好处: 父路径是File类型,父路径可以直接调用File类方法
        File file1 = new File(new File("d:"), "idea");
        //传递路径,传递字符串父路径,字符串子路径，好处: 单独操作父路径和子路径
        File file2 = new File("d:", "idea");
        //传递路径名: 可以写到文件夹,可以写到一个文件,将路径封装File类型对象
        File file3 = new File("d:\\idea");

        /**
         * File的一些方法,删除方法,不走回收站,直接从硬盘中删除,
         */
        //删除的文件或者是文件夹,
        boolean delete = file1.delete();

        //创建文件的功能，创建的文件路径和文件名,在File构造方法中给出，存在则不创建
        try {
            boolean newFile = file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File类的获取功能
        String parent1 = file1.getParent();
        File parent = file1.getParentFile();
        String absolutePath = file1.getAbsolutePath();
        File absoluteFile = file1.getAbsoluteFile();
        //返回路径中表示的文件的字节数
        long length = file1.length();
        String file1Name = file1.getName();
        String path = file1.getPath();
        //获取系统中的所有根目录
        File[] files = File.listRoots();
        //获取到,File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
        File[] files1 = file1.listFiles();
        //获取到,File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
        String[] list = file1.list();

        //判断
        boolean directory = file1.isDirectory();
        boolean exists = file1.exists();

    }


    public static void getAllDir(File dir) {
        System.out.println(dir);
        //调用方法listFiles()对目录,dir进行遍历
        File[] fileArr = dir.listFiles();
        for (File f : fileArr) {
            //判断变量f表示的路径是不是文件夹
            if (f.isDirectory()) {
                //是一个目录,就要去遍历这个目录
                //本方法,getAllDir,就是给个目录去遍历
                //继续调用getAllDir,传递他目录
                getAllDir(f);
            } else {
                System.out.println(f);
            }
        }
    }

    public static void getAllJava(File dir) {
        //调用File对象方法listFiles()获取,加入过滤器
        File[] fileArr = dir.listFiles(new MyJavaFilter());
        for (File f : fileArr) {
            //对f路径,判断是不是文件夹
            if (f.isDirectory()) {
                //递归进入文件夹遍历
                getAllJava(f);
            } else {
                System.out.println(f);
            }
        }
    }

    public void readFile(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
		/*int len = 0 ;
		while((len = fr.read())!=-1){
			System.out.print((char)len);
		}*/
        char[] ch = new char[1024];
        int len = 0;
        while ((len = fr.read(ch)) != -1) {
            System.out.print(new String(ch, 0, len));
        }

        fr.close();
    }

    public void writeFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        //写1个字符
        fw.write(100);
        fw.flush();
        //写1个字符数组
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        fw.write(c);
        fw.flush();
        //写字符数组一部分
        fw.write(c, 2, 2);
        fw.flush();
        //写如字符串
        fw.write("hello");
        fw.flush();

        fw.close();
    }

}

class MyJavaFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        //判断获取的是目录,直接返回true
        if (pathname.isDirectory()) {
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".java");
    }

}
