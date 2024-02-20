package org.minis.beans;

/**
 * 单例的注册、获取、判断是否存在
 */
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName,Object singletonObject);
    Object getSingleton(String beanName);
    boolean containsSingleton(String beanName);
    String[] getSingletonNames();
}
