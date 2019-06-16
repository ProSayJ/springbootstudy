package com.prosayj.springboot.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangjian
 * @description PowerPoint2007版文件工具类
 * 通用的PowerPoint2007版文件工具类，可用于从PowerPoint文档中抽取文本信息
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/15 21:43
 * @since 1.0.0
 */
public class PowerPoint2007FileUtil extends BasePowerPointFileUtil {
    /**
     * <p>从PowerPoint文档中提取文本信息
     *
     * @param  powerPointFile PowerPoint文件
     * @param  shapeSeparator Shape分隔符
     * @param  slideSeparator Slide分隔符
     *
     * @return 提取后的文本信息
     *
     */
    public static String extractTextFromPowerPointFile(File powerPointFile , String shapeSeparator , String slideSeparator) {

        StringBuffer returnValue = new StringBuffer();
        if (powerPointFile != null && slideSeparator != null && shapeSeparator != null) {

            if (powerPointFile.isFile()) {

                try {

                    XMLSlideShow slideShow = new XMLSlideShow(new FileInputStream(powerPointFile));
                    Iterator slideIterator = PowerPoint2007FileUtil.readSlideShow(slideShow).iterator();
                    //遍历Slide
                    while (slideIterator.hasNext()) {

                        Iterator shapeIterator = ((List) slideIterator.next()).iterator();
                        //遍历Shape
                        while (shapeIterator.hasNext()) {

                            Object shapeValue = shapeIterator.next();
                            if (shapeValue != null) {

                                returnValue.append((String) shapeValue);
                                if (shapeIterator.hasNext()) {

                                    returnValue.append(shapeSeparator);
                                }
                            }
                        }
                        if (slideIterator.hasNext()) {

                            returnValue.append(slideSeparator);
                        }
                    }
                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        }
        return StringUtils.trimToNull(returnValue.toString());
    }

//    public static void renderPowerPointTemplate(InputStream powerPoint, Map<String, Object> data) throws IOException {
//        if(powerPoint == null) {
//            return;
//        }
//        XMLSlideShow slideShow = new XMLSlideShow(powerPoint);
//        List slides = slideShow.getSlides();
//        for (int i = 0 ; i < slides.size() ; i++) {
//
//            List shapes = ((Slide)slides.get(i)).getShapes();
//            for (int j = 0 ; j < shapes.size() ; j++) {
//                Shape shape = (Shape) shapes.get(j);
//                PowerPoint2007FileUtil.renderShape(shape, data);
//            }
//        }
//        OutputStream outputStreams = new FileOutputStream("C:\\Users\\Admin\\Desktop\\test.pptx");
//        slideShow.write(outputStreams);
//    }

}
