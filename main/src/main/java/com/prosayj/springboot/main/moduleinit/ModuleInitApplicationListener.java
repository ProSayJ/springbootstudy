package com.prosayj.springboot.main.moduleinit;

import com.prosayj.springboot.constants.LoggerModelEnum;
import com.prosayj.springboot.event.eventcore.moduleinit.AbstractModuleInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @author yangjian
 * @description 模块初始化
 * @Date 16:28 2018/9/20
 * @since 1.0.0
 */
public class ModuleInitApplicationListener implements ApplicationListener<ApplicationReadyEvent>, ApplicationContextAware {

    private final Logger logger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_MAIN.getModuleNickName());

    private ApplicationContext context;

    public ModuleInitApplicationListener() {
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationEvent) {
        Map<String, AbstractModuleInit> modules = this.context.getBeansOfType(AbstractModuleInit.class);
        if (null != modules) {
            AbstractModuleInit[] moduleInit = modules.values().toArray(new AbstractModuleInit[modules.size()]);

            // 按优先级排序
            Arrays.sort(moduleInit, new Comparator<AbstractModuleInit>() {
                @Override
                public int compare(AbstractModuleInit moduleInit1, AbstractModuleInit moduleInit2) {
                    Integer order1 = moduleInit1.order();
                    Integer order2 = moduleInit2.order();

                    return order1.compareTo(order2);
                }
            });

            for (AbstractModuleInit module : moduleInit) {
                module.init();
                logger.info("module initializing, order: {}, name: {}", module.order(), module.getClass().getSimpleName());
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

}
