package org.minis.context;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.minis.beans.*;
import org.minis.core.ClassPathXmlResource;
import org.minis.core.Resource;

import java.net.URL;
import java.util.*;

public class ClassPathXmlApplicaitonContext implements BeanFactory {
    BeanFactory beanFactory;

    public ClassPathXmlApplicaitonContext(String filename) {
        Resource resource = new ClassPathXmlResource(filename);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }
    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
