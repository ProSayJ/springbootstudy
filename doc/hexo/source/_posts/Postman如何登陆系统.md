title: Postman如何登陆系统
author: ProSayJ
tags: []
categories:
  - 工作相关
date: 2019-03-08 10:09:00
---
# 先页面访问页面登陆接口,获取publickey 和nonce

![登陆之前](登陆之前.png)

# 输入用户名和密码：
## 输入：

![输入用户名和密码_输入](输入用户名和密码_输入.png)

## 响应：

![输入用户名和密码_响应](输入用户名和密码_响应.png)

** 这里：前端先获取了login before接口获取了publickey，然后拿着publickey去对用户名和密码进行公钥加密 **

# url的URL Decoder/Encoder
使用[urldencoder在线解析工具](https://meyerweb.com/eric/tools/dencoder/)解析浏览器发给服务器的public key加密的密文：


   password: PBPHRCM1L3VTIfbVcz%2Bas0icImAPTNKsMgmnrgF%2BNB8TZvM7usOohOy92qdDP6Vzgv%2FVXbxLwi9w8Dslc9mJBSOt2xGmFz1qICNQP6N%2BQ1Xlz%2F0sIxO48RYq2Rm14G4pXkgNgrA6vDjwXz%2B66gRNyZasiqiJ9HTRtfKTQy67Cmw%3D
   
   
   username: %7B%22type%22:0,%22value%22:%22jbank1%22,%22pubKey%22:%22MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDYMqg2xpt4WAB3tV9j0UyK7TbEX4ZPCk2kXQBtKBfbjSNkBoYwTDuSL6XG%252FSllTTsdAN%252FoN4kKwE3nkDbLcIcU3MiXIs3IBi3AkpBaPj1gggy%252FFggFeX97jxpT9Y%252FL6Nto7p05MLF%252B23uwWladL3Smx3PZwXbDwqbZIo4pYMKrwIDAQAB%22%7D
   
 ## Decoder_pwd:
   
![Decoder_pwd](Decoder_pwd.png)


## Decoder_userInfoAndPublicKey:
![Decoder_userInfoAndPublicKey](Decoder_userInfoAndPublicKey.png\)


# postman使用decoder的用户信息和密码访问登陆接口

![postman登陆接口](postman登陆接口.png)

``` json
{
    "success": true,
    "data": {
        "access_token": "1a23b3b1-5e04-4d3c-9dde-a0d924e37636",
        "token_type": "bearer",
        "refresh_token": "b3822593-2ae5-47e6-a33f-f3299321ff52",
        "expires_in": 1798,
        "scope": "all"
    },
    "errorCode": null,
    "errorMessage": null
}

```

# 校验证书：
## 先页面校验证书：获取和证书相关的签名:

**输入用户名和密码登陆成功以后，选择证书登陆系统**


![证书登陆系统](证书登陆系统.png)

``` json
{
    "serialNo": "1010977251",
    "issuerDn": "CN=CFCA TEST OCA1, O=China Financial Certification Authority, C=CN",
    "sequenceNo": "301445631304531968",
    "signStr": "MIIFLAYJKoZIhvcNAQcCoIIFHTCCBRkCAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggPlMIID4TCCAsmgAwIBAgIFEBCXclEwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDUyMDU5WhcNMTkxMDIzMDUyMDU5WjCBmDELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFLMEkGA1UEAwxCMDQxQE45MTM0MDg4MTY3NDIzMDA4MFVA5a6J5b695pe65p2l5peg57q65biD5pyJ6ZmQ5YWs5Y-4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjz3skGnkEQljL4/yAhpiiRO1pKOiwx0sbm8WrRRmmUiTsXsrtJMWP782nWNv27EVPS7rLOgecPHRZr38WBtOuv5Qava3opKML32Vi3N8UN2KQRBU75Hcjc0IVMg5BgGId96tNRKHggVKM5HRFM6vqJ7Kw2SX2pV5hZ/RgG/e6nQIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3-M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA-gwHQYDVR0OBBYEFAn/-cLg7oxDH0ASzCr3CRJ6beLVMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEAAwcjnelyBZLvh0Yxef8Uquy/UDRr3ygbfrfkcMET34QDPNzFwAhUk9roZYva2a6r8yeQ0euAFi2yYbmSA98A-d1r7HCe-gWp6Qj2jM1tnK-FayrpkAlH1k2Gfr9gSlRGWIlewTVduGu7jQPI9aBMEEIGIZCA2zsdmxWcLb6f0lZSwwAPZ7xYGNv552btMw9LkXoX2RSQ1lFAE0Zv3IGqGOdaNJspoKUZebZTbJ6Ims7f8z/pyC7H9-ZeqcELy9vdGpo1nxgfSFhASIAIqb4VSfbXf/CpmxvHKqUXE5wVUXURicSWtVYhDsOmEvsCVy0Rv53a5TMJZ2pAacEl46bC4zGCAQswggEHAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JRMA0GCWCGSAFlAwQCAQUAMA0GCSqGSIb3DQEBCwUABIGAGgri4NYybOmebIg38nauB4eH9ohQYQf4oVWS7H5p42Xn1iB3Eawc9gGBEToPbawzo9Gpz6m3lfpQYDIEi-gxMinqEDOyPJRpHt5PbwiTYyYqxadefYbqdukLxy-baDopALLcprA/sqdB4vK1fxm81L/qJgAtjS6cf4o-D9Tm4Q4=",
    "refreshToken": "eb1b4a53-174b-46b6-b2fa-6847966e674d"
}

```

## postman请求证书验证接口
**如果上一步返回token过期则使用第三部返回的两个token替换即可**


![token过期](token过期.png)


![证书验证通过](证书验证通过.png)

# 访问务接口

**需要证书和上下文的业务接口带着验证登陆证书接口返回的access_token即可**





