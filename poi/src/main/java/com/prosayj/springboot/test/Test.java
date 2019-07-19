package com.prosayj.springboot.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.*;
import java.util.*;

/**
 * @author yangjian
 * @description 测试删除ppt的sheet页
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/16 下午 01:10
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        XMLSlideShow pptTemplet = readPowerPoint();
        List<XSLFSlide> slideList = pptTemplet.getSlides();

        //ppt模板的总页码
        List<Integer> pptAllPages = new ArrayList<>();
        for (int i = 0; i < slideList.size(); i++) {
            pptAllPages.add(i);
        }
        System.out.println("ppt模板的总页码" + pptAllPages);
        //有数据的页码
        List<Integer> hasDataPage = new ArrayList<>();
        hasDataPage.add(3);
        hasDataPage.add(0);
        hasDataPage.add(7);
        System.out.println("有数据的页码是：" + hasDataPage);

        //集合过删除总的页码中有数据的页码
        pptAllPages.removeIf(pageNo -> hasDataPage.contains(pageNo));
        System.out.println("待删除的ppt页码有" + pptAllPages);

        //待删除的ppt页码倒叙排列
        pptAllPages.sort(Comparator.reverseOrder());
        System.out.println("待删除的ppt页码倒叙排列" + pptAllPages);
        pptAllPages.forEach(index -> {
            //循环删除
            pptTemplet.removeSlide(index);
        });
        //保存处理过后的ppt
        savePowerPoint(pptTemplet);

    }

    /**
     * 读取模板库PPT
     *
     * @return
     * @throws IOException
     */
    public static XMLSlideShow readPowerPoint() throws IOException {
        XMLSlideShow ppt = null;
        try {
            //InputStream templateFile = new ClassPathResource("model.pptx").getInputStream();
            InputStream templateFile = Test.class.getClassLoader().getResourceAsStream("model.pptx");
            ppt = new XMLSlideShow(templateFile);
        } catch (IOException e) {
        }
        return ppt;
    }

    private static void savePowerPoint(XMLSlideShow ppt) throws IOException {
        String parentDir = System.getProperty("user.dir") + File.separator;
        String fileName = UUID.randomUUID().toString() + ".pptx";
        String pptName = "导出数据";
        if (!StringUtils.isEmpty(pptName)) {
            //fileName = pptName + "_" + System.currentTimeMillis() + "_.pptx";
            fileName = pptName + "_.pptx";
        }

        String fullPath = parentDir + fileName;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ppt.write(fileOutputStream);
        fileOutputStream.close();
        ppt.close();
        File file = new File(fullPath);
        try {
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream("\\" + fullPath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            //file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
