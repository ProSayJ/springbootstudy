package com.prosayj.springboot.java数据结构;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/27 下午 09:01
 * @since 1.0.0
 */
public class SniffDir {
    private String srcDir;
    private Vector<String> vs;

    public SniffDir() {
        srcDir = "D:\\workspace\\git\\jdk1.8.0_71_src\\src";
        vs = new Vector<String>();
    }

    /**
     * Sniff函数， 其实就是一个DFS，深度优先搜索
     * 用来获取src目录下的满足“当前路径下存在.java文件”这一条件的所有文件夹
     *
     * @param file
     */
    public void Sniff(File file) {
        //File file=new File(curDir);
        File[] files = file.listFiles();
        int len = files.length;
        boolean ok = false;//表示当前目录下是否有java文件，ok=true表示有并且记录过了。
        for (int i = 0; i < len; i++) {
            //System.out.println(files[i].toString());
            if (files[i].isDirectory()) {
                Sniff(files[i]);
            } else if (files[i].isFile() && !ok) {//files[i]为文件（肯定是java文件），并且还没有把当前路径放入向量vs中
                ok = true;
                vs.addElement(file.toString().substring(srcDir.length() + 1));
                //System.out.println(files[i].toString());
            }
        }
    }

    String sb = null;

    public void Print() {
        int len = vs.size();
        for (int i = 0; i < len; i++) {
            sb = vs.get(i);
            sb = sb.replace('\\', '.');
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        /*SniffDir sd = new SniffDir();
        sd.Sniff(new File(sd.srcDir));
        sd.Print();*/
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

    }

}
