package com.prosayj.springboot.并发编程的艺术.chapter03;

public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance; //���ｫ����InstanceHolder�౻��ʼ��
    }

    static class Instance {
    }
}
