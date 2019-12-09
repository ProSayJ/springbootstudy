package com.prosayj.springboot;

import com.prosayj.springboot.event.eventcore.EventConfig;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/5 14:06
 * @since 1.0.0
 */
@ComponentScan(basePackageClasses = {BussinessConfig.class,EventConfig.class})
public class BussinessConfig {
}
