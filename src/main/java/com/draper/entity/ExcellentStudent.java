package com.draper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ExcellentStudent implements Comparable<ExcellentStudent>, Serializable {

    private long id;
    private String img;
    private String position;
    private String name;
    private String description;
    private int salary;
    @JsonIgnore
    private long createAt;
    @JsonIgnore
    private long updateAt;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public int compareTo(ExcellentStudent o) {
        if (o.getSalary() > salary) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
