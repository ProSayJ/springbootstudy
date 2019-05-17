package com.prosayj.springboot.designmode.研磨设计模式._11_observer._00;


/**
 * https://www.cnblogs.com/fingerboy/p/5468994.html
 *
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/24 9:25
 * @since 1.0.0
 */
public class _TestObserver {
    public static void main(String[] args) {

        // 订阅者
        TeacherSubject teacher = new TeacherSubject();

        //观察者：观察谁老师的一举一动
        StudentObserver zhangSan = new StudentObserver("张三", teacher);
        StudentObserver LiSi = new StudentObserver("李四", teacher);
        StudentObserver WangWu = new StudentObserver("王五", teacher);

        teacher.setHomework("第二页第六题");
        teacher.setHomework("第三页第七题");
        teacher.setHomework("第五页第八题");
    }
}

