package com.prosayj.springboot.blog.core.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;


/**
 * @author yangjian
 * @description 云存储配置类
 * @Date 12:16 2019/5/13
 * @since 1.0.0
 */
@Data
@Configuration
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value("${oss.qiniu.domain}")
    private String qiniuDomain;
    /**
     * 七牛路径前缀
     */
    @Value("${oss.qiniu.prefix}")
    private String qiniuPrefix;
    /**
     * 七牛ACCESS_KEY
     */
    @Value("${oss.qiniu.accessKey}")
    private String qiniuAccessKey;
    /**
     * 七牛SECRET_KEY
     */
    @Value("${oss.qiniu.secretKey}")
    private String qiniuSecretKey;
    /**
     * 七牛空间名
     */
    @Value("${oss.qiniu.bucketName}")
    private String qiniuBucketName;
}
