package com.prosayj.springboot.dbbackup;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.DefaultText;

import java.util.Iterator;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/26 下午 02:26
 * @since 1.0.0
 */
public class Hello {
    public static void main(String[] args) throws DocumentException {
        //String s = "<\u0002!x `fbon xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" Version=\"2.0\" ID=\"_0cc12b22-504c-4c96-a73d-29efa1f69e3d\" IssueInstant=\"2019-07-26T02:08:29.6933879Z\" xmlns=\"urn:oasis:names:tc:SAML:2.0:assertion\"><Issuer>SinopecMobileIssuer</Issuer><Subject><NameID NameQualifier=\"SinopecMobileDomain\">SinopecMobileSubject</NameID><SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\"><SubjectConfirmationData /></SubjectConfirmation></Subject><Conditions NotBefore=\"2019-07-26T02:08:29.6933879Z\" NotOnOrAfter=\"2019-08-05T02:08:29.6933879Z\"><AudienceRestriction><Audience>SinopecMobileDomain</Audience></AudienceRestriction></Conditions><AuthnStatement AuthnInstant=\"2019-07-26T02:08:29.6933879Z\"><SubjectLocality Address=\"fe80::54fe:47c:92a6:6e7a%12\" /><AuthnContext><AuthnContextClassRef>AuthnContextClassRef</AuthnContextClassRef></AuthnContext></AuthnStatement><AttributeStatement><Attribute Name=\"UserId\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\"><AttributeValue xsi:type=\"xsd:string\">junwei.yang</AttributeValue></Attribute><Attribute Name=\"Acount\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\"><AttributeValue xsi:type=\"xsd:string\">yangjw1988</AttributeValue></Attribute><Attribute Name=\"Password\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:basic\"><AttributeValue xsi:type=\"xsd:string\">Yangjunwei@#11</AttributeValue></Attribute></AttributeStatement><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" /><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\" /><Reference URI=\"\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" /><DigestValue>brAY7Xu/kambEhZk0EngAt8KOXs=</DigestValue></Reference></SignedInfo><SignatureValue>UDX4pF84DieCmmtovn22ExnkWvifPHfAqiSZy0IjM/hNu8vJhT8G59oiNIxMXd3Usx0inUKAdgz8K9m+2QobxwYBhIbejVyTQfyqd9VfuH0o9COBO2s/E4+nQ08edUanJsfGZmSwGlibkJKXQexsdxId/GZ8sUHy2jO1NrGVJBBUvlLYw5GX4cfffft7AwaCPrVvCoHvRmygUeqwEzHZfFjJpLiVNilCzp8oTUAWtHGflS1rF3iUBndqG1NXNOpvu6l1mdmQSaWMfnEccy9fb2fDj4AOqUmirdrk40ne/XtHc9NGEzS5s1wmDooj+i8YAzkiQ4N3L7/auS1i+MaVlQ==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIICPTCCAeugAwIBAgIQI29rwQcSfpVMdqXHeaLzmTAJBgUrDgMCHQUAMBYxFDASBgNVBAMTC1Jvb3QgQWdlbmN5MB4XDTE1MTAwOTA3NDg1OFoXDTM5MTIzMTIzNTk1OVowHDEaMBgGA1UEAxMRU2lub3BlY01vYmlsZVNhbWwwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCQ+iovahsQzjIFCxFH62gRvGLYrjmkqbyyia/S6iqBQZpp00g/jQq3bWwYLzNlw3Vrpg4ijwsI0DOkQ5iPeIg6aNvO9riMoZFQS2ORhdIHQ0QC2A39Zg70wwBYJ19AqKtj4l7NOSdIwchdyPakjrmlIJxwscDexdCbgav3tGZ0mFcZufGilwjVJHMbjmv+GpGgQD3oePqTpA9c0u0mJd27aadcLQrSwALBJFVPz58n/jXbebLOzCxTw8XZrJTZavkewfSg/0Ca89fKvbE0R0TPAVOeEA3rqItE9p6iZtQ1rfWY+WG88mE7LcU51/hHO7SbeoUXyyV7f82Z3jkaUF+NAgMBAAGjSzBJMEcGA1UdAQRAMD6AEBLkCS0GHR1PAI1hIdwWZGOhGDAWMRQwEgYDVQQDEwtSb290IEFnZW5jeYIQBjdsAKoAZIoRz7jUqlw19DAJBgUrDgMCHQUAA0EANehA6GGjpz0LMR1FzmyVyb90sMzUtI1StKKWYP+NYDh5vz0JFXEl7eVgSpGtM97E+Oeh2kWNMU3xzsOfOiYwjQ==</X509Certificate></X509Data></KeyInfo></Signature></Assertion>";
        String mw="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";
        DES3Utils dES3Utils=new DES3Utils("1qaz2wsx3edc4rfv5tgb6yhn");
        String s = dES3Utils.des3Decode(mw);
        String target = s.substring(s.lastIndexOf("<AttributeStatement>"), s.lastIndexOf("</AttributeStatement>"));
        String s1 = target.replaceAll("xsi:type=\"xsd:string\"", "");
        s1 = s1 + "</AttributeStatement>";
        Element rootElement = DocumentHelper.parseText(s1).getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            String name = element.attributeValue("Name");
            Element e = (Element) element.content().get(0);
            DefaultText defalutValue = (DefaultText) e.content().get(0);

            System.out.println(name + "<===>"+defalutValue.getText());
        }


    }
}
