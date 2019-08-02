package com.ken.demo.entity;

import java.io.Serializable;

public class ModuleVo implements Serializable {
    String order;
    String name;
    String types;
    String resourceId;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "ModuleVo{" +
                "order='" + order + '\'' +
                ", name='" + name + '\'' +
                ", types='" + types + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
