package com.prosayj;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/1 9:47
 * @since 1.0.0
 */
public class Swagger2Markup {
    /*
    public Swagger2Markup() throws Exception{
        createHtmlFile();
    }
*/
    public static void main(String[] args) throws Exception {
//        new Swagger2Markup();

    }

    /**
     * 生成AsciiDocs格式文档
     * @throws Exception
     */
    /*
    public static void generateAsciiDocs(String swaggerJsonUrl,String filePath) throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)//设置生成格式
                .withOutputLanguage(Language.EN)//设置语言英文，中文可能是乱码
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
        //设置swagger-api的json来源
        Swagger2MarkupConverter.from(new URL(swaggerJsonUrl))
                .withConfig(config)
                .build()
                .toFile(Paths.get(filePath));//设置生成文件的路径
    }
*/
    /**
     * 生成Markdown格式文档
     * @throws Exception
     */
    /*
    public static void generateMarkdownDocs(String swaggerJsonUrl,String filePath) throws Exception {
        //    输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(swaggerJsonUrl))
                .withConfig(config)
                .build()
                .toFile(Paths.get(filePath));
    }
    */

    /**
     * 生成Confluence格式文档
     * @throws Exception
     */
    /*
    public static void generateConfluenceDocs(String swaggerJsonUrl,String filePath) throws Exception {
        //    输出Confluence使用的格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(swaggerJsonUrl))
                .withConfig(config)
                .build()
                .toFile(Paths.get(filePath));
    }
*/
    /**
     * 创建html和pdf文件
     *
     * @throws Exception
     */
    public void createHtmlFile() throws Exception {
        //获取pom.xml的绝对路径
        String path = returnPath("pom.xml");

        //生成bat文件的内容
        StringBuilder batFileContent = new StringBuilder(path.substring(0, 2)).append("\r\n");
        batFileContent.append("cd ").append(path.substring(0, path.length() - 7)).append("\r\n");
        batFileContent.append("mvn test");

        //写入到bat文件
        writeInBatFile("src/cmd/bat.bat", batFileContent.toString().replace("/", "\\"));

        //生成vbs文件内容
        StringBuilder vbsFileContent = new StringBuilder("Set ws = CreateObject(\"Wscript.Shell\")").append("\r\n");
        vbsFileContent.append("ws.run \"cmd /c ").append(returnPath("src/cmd/bat.bat").replace("/", "\\")).append("\",vbhide");

        //写入vbs文件
        writeInBatFile("src/cmd/vbs.vbs", vbsFileContent.toString());

        //生成执行vbs文件命令(用vbs隐藏bat文件执行时的窗口)
        StringBuilder cmd = new StringBuilder("cmd /c CScript ").append(returnPath("src/cmd/vbs.vbs"));

        System.out.println(cmd.toString());

        Process process = Runtime.getRuntime().exec(cmd.toString());

        System.out.println(process.waitFor());
    }

    /**
     * 生成文件
     *
     * @param content
     */
    public void writeInBatFile(String fileName, String content) {
//        fileName = fileName  + "protal/";
        File batFile = new File(returnPath(fileName));
        //如果文件存在，则删除
        if (batFile != null && batFile.exists()) {
            batFile.delete();
        }
        /*try {
            batFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            //创建gbk格式的文件（utf-8中文在cmd里乱码）
            FileOutputStream out1 = new FileOutputStream(batFile);
            OutputStreamWriter out = new OutputStreamWriter(out1, "GBK");
            BufferedWriter bw = new BufferedWriter(out);
            bw.write(content);
            bw.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定文件路径
     *
     * @param filePath
     * @return
     */
    public String returnPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().toString();
    }
}
