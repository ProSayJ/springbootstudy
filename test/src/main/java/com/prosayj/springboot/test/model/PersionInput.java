package com.prosayj.springboot.test.model;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/18 下午 03:20
 * @since 1.0.0
 */
public class PersionInput {
    private String name;
    private String age;
    private BaseVO baseVO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public <T extends BaseVO> T getBaseVO() {
        T baseVO = (T) this.baseVO;
        return baseVO;
    }

    public void setBaseVO(BaseVO baseVO) {
        this.baseVO = baseVO;
    }
}
