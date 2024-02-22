package org.minis.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues() {
        this.propertyValueList = new ArrayList<PropertyValue>(10);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
    public int size(){
        return this.propertyValueList.size();
    }
    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }
    public void addPropertyValue(String type, String name, Object value){
        this.propertyValueList.add(new PropertyValue(type,name,value));
    }
    public void removePropertyValue(PropertyValue propertyValue){
        this.propertyValueList.remove(propertyValue);
    }
    public void removePropertyValue(String name){
        this.propertyValueList.remove(getPropertyValue(name));
    }

    public PropertyValue getPropertyValue(String name) {
        for(PropertyValue propertyValue : this.propertyValueList){
            if(propertyValue.getName().equals(name)){
                return propertyValue;
            }
        }
        return null;
    }
    public boolean contains(String propertyyName) {
        return (getPropertyValue(propertyyName) != null);
    }
    public boolean isEmpty() {
        return this.propertyValueList.isEmpty();
    }




}
