package com.nfdw.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware {
    
    private static ApplicationContext context; // 声明一个静态变量保存
                                               
    
     /*static { context = new ClassPathXmlApplicationContext(
     "classpath*:conf/applicationContext-*.xml"); }*/
     
    @Override
    public void setApplicationContext(ApplicationContext contex) {
        ApplicationContextUtil.context = contex;
    }
    
    public static ApplicationContext getContext() {
        return ApplicationContextUtil.context;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getBean(final String beanId) {
        return (T) ApplicationContextUtil.context.getBean(beanId);
    }
    
    public static boolean containsBean(final String beanId) {
        return ApplicationContextUtil.context.containsBean(beanId);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getBean(final String beanId, Object... args) {
        return (T) ApplicationContextUtil.context.getBean(beanId, args);
    }
    
    public static <T> T getBean(Class<T> clazz){
    	return (T) ApplicationContextUtil.context.getBean(clazz);
    }
}
