package org.minis.beans;

import org.dom4j.Element;
import org.minis.core.Resource;

import java.util.List;

public class XmlBeanDefinitionReader {
    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader( SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }
    public void loadBeanDefinitions(Resource resource){
        while (resource.hasNext()) {
            Element element = (Element)resource.next();
            String beanID=element.attributeValue("id");
            String beanClassName=element.attributeValue("class");

            BeanDefinition beanDefinition=new BeanDefinition(beanID,beanClassName);

            //handle properties
            List<Element> propertyElements = element.elements("property");
            PropertyValues PVS = new PropertyValues();
            for (Element e : propertyElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                PVS.addPropertyValue(new PropertyValue(pType, pName, pValue));
            }
            beanDefinition.setPropertyValues(PVS);
            //end of handle properties

            //get constructor
            List<Element> constructorElements = element.elements("constructor-arg");
            ArgumentValues AVS = new ArgumentValues();
            for (Element e : constructorElements) {
                String pValue = e.attributeValue("value");
                String pName = e.attributeValue("name");
                String pType = e.attributeValue("type");
                AVS.addArgumentValue(new ArgumentValue(pValue,pName,pType));
            }
            beanDefinition.setConstructorArgumentValues(AVS);
            //end of handle constructor

            this.simpleBeanFactory.registerBeanDefinition(beanID,beanDefinition);
        }
    }
}
