package org.minis.beans;

import java.util.ArrayList;
import java.util.List;

public class ArgumentValues {
    private final List<ArgumentValue> argumentValueList = new ArrayList<>();

    public ArgumentValues() {
    }
    public void addArgumentValue(ArgumentValue argumentValue){
        this.argumentValueList.add(argumentValue);
    }

    public ArgumentValue getIndexArgumentValue(int index) {
        return this.argumentValueList.get(index);
    }
    public int getArgumentCount(){
        return this.argumentValueList.size();
    }
    public boolean isEmpty(){
        return this.argumentValueList.isEmpty();
    }
}
