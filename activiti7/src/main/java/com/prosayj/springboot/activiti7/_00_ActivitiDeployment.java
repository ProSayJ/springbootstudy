package com.prosayj.springboot.activiti7;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @author yangjian
 * @description 流程定义的部署
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/18 下午 10:05
 * @since 1.0.0
 */
public class _00_ActivitiDeployment {
    //测试流程定义的部署
    public static void main(String[] args) {
        //1：创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2：得到部署相关的service：ReposioryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3：进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")//添加bpmn资源
                .addClasspathResource("diagram/holiday.png")//添加
                .name("请假申请流程单")
                .deploy();//部署

        //4：输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());


    }
}
