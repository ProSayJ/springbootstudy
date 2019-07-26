package com.prosayj.springboot.dbbackup;


import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;


/**
 * 项目名称：fpms-platform<br>
 * *********************************<br>
 * <P>类名称：DES3Utils</P>
 * *********************************<br>
 * <P>类描述：</P>
 * 创建时间：2019/7/19 12:18<br>
 * 修改备注：<br>
 *
 * @version 1.0<br>
 */
public class DES3Utils {
    	public static void main(String[] args) {
    	    String mw="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";
            DES3Utils dES3Utils=new DES3Utils("1qaz2wsx3edc4rfv5tgb6yhn");
            try {
                String s = dES3Utils.des3Decode(mw);
                System.out.println(s);
               /* Document document= DocumentHelper.parseText(s);//xmlStr为上图格式的字符串
                List list = document.selectNodes("AttributeStatement");
                	System.out.println(list.size());*/
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

    //秘钥（身份验证）
    private byte[] key ;//1qaz2wsx3edc4rfv5tgb6yhn 长度24
    private byte[] keyiv ;//长度为8
    //秘钥（web组件）
    private byte[] key0 ;//1qaz2wsx3edc4rfv5tgb6yhn 长度24
    private byte[] keyiv0 ;//长度为8
    public DES3Utils(String keys) {
        try {
            key = keys.getBytes("UTF-8");
            keyiv = "123qweas".getBytes("UTF-8");
            key0 = keys.getBytes("UTF-8");
            keyiv0 = "sin0opec".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public String des3Decode(String str ){
        String deString = null;
        byte[] test1 = Base64.decodeBase64(str);
        try {
            //CBC 解密
            byte[] str1 = des3DecodeCBC(test1);
            deString = new String(str1,"UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return deString;
    }
    public String des3Decode0(String str ){
        String deString = null;
        byte[] test1 = Base64.decodeBase64(str);
        try {
            //CBC 解密
            byte[] str1 = des3DecodeCBC0(test1);
            deString = new String(str1,"UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return deString;
    }
    /**
     * CBC 加密
     *
     * @param data 加密明文
     * @return
     * @throws Exception
     */
    public  byte[] des3EncodeCBC(byte[] data)throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede" + "/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(keyiv);
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] bOut = cipher.doFinal(data);
        return bOut;
    }
    /**
     * CBC  解密(身份验证)
     *
     * @param data
     * @return
     * @throws Exception
     */
    private   byte[] des3DecodeCBC(byte[] data)throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede" + "/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(keyiv);
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        byte[] bOut = cipher.doFinal(data);
        return bOut;

    }
    /**
     * CBC  解密（web组件）
     *
     * @param data
     * @return
     * @throws Exception
     */
    private   byte[] des3DecodeCBC0(byte[] data)throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key0);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede" + "/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(keyiv0);
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        byte[] bOut = cipher.doFinal(data);
        return bOut;

    }
    private String getAcountxml(String keyxml){
        int beginIndex = keyxml.indexOf("<AttributeStatement>");
        int endIndex = keyxml.indexOf("</AttributeStatement>");
        keyxml = keyxml.substring(beginIndex, endIndex);
        keyxml = keyxml+"</AttributeStatement>";
        return keyxml;
    }
    private String[] getUserAndPsdfromToken0 (String key){
        String[] initenstr = new String[2];
        String[] str1 = key.split(",");
        if (str1.length<1) {
            return null;
        }
        String[] str2=str1[0].split(":");
        String[] str3=str1[1].split(":");
        if (str2.length>1&&str3.length>1) {
            initenstr[0]=str2[1];
            initenstr[1]=str3[1];
        }
        return initenstr;
    }
    private Map<String,String> parseUsernameAndPsd(String keyxml){
        Map<String,String> keymap = new HashMap<String,String>();
        String username = "";
        String password = "";
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new InputSource(new StringReader(keyxml)));
            NodeList employees = document.getElementsByTagName("Attribute");
            for(int i = 0 ; i < employees.getLength();i++){
                Node node = employees.item(i);
                NamedNodeMap NodeMap = node.getAttributes();
                String value = NodeMap.getNamedItem("Name").getNodeValue();
                System.out.println(value);
                if("UserId".equals(value)){
                    username = node.getTextContent().trim();
                }else if("Password".equals(value)){
                    password = node.getTextContent().trim();
                }
            }
            System.out.println("ceshi user: " + username + " password:" + password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        keymap.put("username", username);
        keymap.put("password", password);
        return keymap;
    }

    public Map<String,String> getAcountByToken(String key){
        String keyxml = getAcountxml(key);
        return parseUsernameAndPsd(keyxml);
    }

    public Map<String,String> getAcountByToken0(String key){
        Map<String,String> keymap = new HashMap<String,String>();
        String[] initenstr = getUserAndPsdfromToken0(key);
        String username = initenstr[0];
        String password = initenstr[1];
        keymap.put("username", username);
        keymap.put("password", password);
        return keymap;
    }

}