package com.ken.demo.entity;

import java.io.Serializable;

public class TypeVo implements Serializable {
    String order;
    String errorCode;
    String name;
    String description;
    String group;
    String scope;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "TypeVo{" +
                "order='" + order + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", group='" + group + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
