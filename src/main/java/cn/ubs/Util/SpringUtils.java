package cn.ubs.Util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/*
    该工具类目的是为了通过数据库查询的数据配置来决定注入那个实现类
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    // final 入参不能被修改
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(String beanName,Class<T> clazz){
        return applicationContext.getBean(beanName,clazz);
    }

}
