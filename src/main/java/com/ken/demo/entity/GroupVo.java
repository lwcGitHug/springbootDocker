package com.ken.demo.entity;

import java.io.Serializable;

public class GroupVo implements Serializable {
    String order;
    String name;
    String description;
    String raiseDuration;
    String raiseThreshold;
    String clearDuration;
    String clearThreshold;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRaiseDuration() {
        return raiseDuration;
    }

    public void setRaiseDuration(String raiseDuration) {
        this.raiseDuration = raiseDuration;
    }

    public String getRaiseThreshold() {
        return raiseThreshold;
    }

    public void setRaiseThreshold(String raiseThreshold) {
        this.raiseThreshold = raiseThreshold;
    }

    public String getClearDuration() {
        return clearDuration;
    }

    public void setClearDuration(String clearDuration) {
        this.clearDuration = clearDuration;
    }

    public String getClearThreshold() {
        return clearThreshold;
    }

    public void setClearThreshold(String clearThreshold) {
        this.clearThreshold = clearThreshold;
    }

    @Override
    public String toString() {
        return "GroupVo{" +
                "order='" + order + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", raiseDuration='" + raiseDuration + '\'' +
                ", raiseThreshold='" + raiseThreshold + '\'' +
                ", clearDuration='" + clearDuration + '\'' +
                ", clearThreshold='" + clearThreshold + '\'' +
                '}';
    }
}
