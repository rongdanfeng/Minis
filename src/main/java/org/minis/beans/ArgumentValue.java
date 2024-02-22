package org.minis.beans;

import lombok.Data;

@Data
public class ArgumentValue {
    private Object value;
    private String name;
    private String type;

    public ArgumentValue(Object value, String name, String type) {
        this.value = value;
        this.name = name;
        this.type = type;
    }

    public ArgumentValue(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

