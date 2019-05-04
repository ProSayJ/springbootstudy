package com.prosayj.springboot._03_Java8实战._01;

import java.io.File;
import java.io.FileFilter;

public class ListFile {
    public static void main(String[] args) {


        //jdk1.8之前
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();//筛选隐藏文件

            }
        });

        //jdk1.8
        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
    }
}
