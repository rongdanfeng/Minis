package org.minis;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.*;

public class ClassPathXmlApplicaitonContext {
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private Map<String, Object> singletons = new HashMap<>();

    public ClassPathXmlApplicaitonContext(String filename) {
        this.readXml(filename);
        this.instanceBeans();
    }

    private void instanceBeans() {
        for (BeanDefinition beanDefinition:beanDefinitions) {
            try {
                singletons.put(beanDefinition.getId(),  Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void readXml(String filename) {
        SAXReader saxReader = new SAXReader();
        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(filename);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();
            //对配置文件中每一个bean。进行处理
            for (Element element: (List<Element>)rootElement.elements()) {
                String beanID = element.attributeValue("id");
                String beanClassName = element.attributeValue("class");
                BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
                beanDefinitions.add(beanDefinition);
            }
        }catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String beanName){
        return singletons.get(beanName);
    }
}
