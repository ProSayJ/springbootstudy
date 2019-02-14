package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter9;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

public static void main(String[] args) throws IOException {

		Path path=Paths.get("记事.txt");
		System.out.println(path.getRoot());
		System.out.println(path.toString());
		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getName(path.getNameCount()-1));

		Path realPath=path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		System.out.println(realPath.getRoot());
		System.out.println(realPath);

		Path path1 = Paths.get("c:/", "adb/sub1");
	    Path path2 = Paths.get("folder2", "sub2");
	    //Path接口中resolve方法的作用相当于把当前路径当成父目录，而把参数中的路径当成子目录或是其中的文件，进行解析之后得到一个新路径；
	    Path path3 = path1.resolve(path2);//c:\sub1\folder2\sub2
	    System.out.println(path3.toString());

	    //resolveSibling方法的作用与resolve方法类似，只不过把当前路径的父目录当成解析时的父目录；
	    Path path4 = path1.resolveSibling(path2);
	    System.out.println(path4.toString());//c:\folder2\sub2

	    //relativize方法的作用与resolve方法正好相反，用来计算当前路径相对于参数中给出的路径的相对路径；
	    path2 = Paths.get("c:/", "sub2");
	    Path path5 = path1.relativize(path2);
	    System.out.println(path5.toString());//..\..\sub2
	}

}
