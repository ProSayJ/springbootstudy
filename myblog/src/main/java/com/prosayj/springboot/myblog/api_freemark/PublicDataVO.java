package com.prosayj.springboot.myblog.api_freemark;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/20 9:18
 * @since 1.0.0
 */
public class PublicDataVO {
    private PublicModulePageVO data;

    public PublicModulePageVO getData() {
        return data;
    }

    public void setData(PublicModulePageVO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PublicDataVO{" +
                "data=" + data +
                '}';
    }
}
