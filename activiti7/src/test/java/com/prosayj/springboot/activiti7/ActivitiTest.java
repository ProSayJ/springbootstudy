package com.prosayj.springboot.activiti7;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * @author yangjian
 * @description
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/18 上午 12:31
 * @since 1.0.0
 */
public class ActivitiTest {
    @Test
    public void testGenTable_01() {
        //1:创建一个ProcessEngineConfiguration
        ProcessEngineConfiguration configuration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml", "processEngineConfiguration");

        //2:创建一个ProcessEngine 对象
        ProcessEngine processEngine = configuration.buildProcessEngine();

        HistoryService historyService = processEngine.getHistoryService();

    }

    @Test
    public void testGenTable_02(){
        //条件1：activiti配置文件名称必须叫：activiti.cfg.xml
        //条件2：beande id = "processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    }
}
