package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._01;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/10 18:28
 * @since 1.0.0
 * 1.	 Array. sort方法中的比较器代码的线程与调用sort的线程是同一个吗？
 * 2.	使用java.io.File类的listFiles(FileFilter）和isDirectory方法，编一写个返回指定目录下所有子目录的方法。使用lambda表达式来代替FileFilter对象，再将它改写为一个方法引用。
 * 3.	使用java.io.File类的list(FilenameFilter）方法，编写一个返回指定目录下、具有指定扩展名的所有文件。使用lambda表达式（而不是FilenameFilter) 来实现。它会捕获闭合作用域中的哪些变量？
 * 4.	对于一个指定的File对象数组，首先按照路径的目录排序，然后对每组目录中的元素再按照路径名排序。便请用lambda表达式（而不是Comparator）来实现。
 * 5.	从你的项目中选取－个包含一些ActionListener、Runnable或者其他类似代码的文件。将它们替换为lambda表达式。这样能节省多少行代码？替换后的代码是否具有更好的可读性？在这个过程中你使用了方法引用吗？
 */
public class _09_Exercise {
    public static void main(String[] args) {
        listSubDirectory(new File(Paths.get("E:").toString()));
    }

    /**
     * 2.	使用java.io.File类的listFiles(FileFilter）和isDirectory方法，
     * 编一写个返回指定目录下所有子目录的方法。使用lambda表达式来代替FileFilter对象，再将它改写为一个方法引用。
     */
    public static void listSubDirectory(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    File fileSub = files[i];
                    if (fileSub.isFile()) {
                        continue;
                    } else if (fileSub.isDirectory()) {
                        System.out.println(fileSub.getName());
                        listSubDirectory(fileSub);
                    }
                }
            }
        }
    }
}




