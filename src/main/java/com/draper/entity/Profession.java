package com.draper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Profession {

    private long id;
    private String img;
    private String developmentDirection;
    private String professionName;
    private String description;

    @JsonIgnore
    private long createAt;

    @JsonIgnore
    private long updateAt;

    private int limitCondition;
    private int difficult;
    private int periodOne;
    private int periodTwo;
    private int carrerProspects;
    private double salaryOne;
    private double salaryTwo;
    private double salaryThree;


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

    public String getDevelopmentDirection() {
        return developmentDirection;
    }

    public void setDevelopmentDirection(String developmentDirection) {
        this.developmentDirection = developmentDirection;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getLimitCondition() {
        return limitCondition;
    }

    public void setLimitCondition(int limitCondition) {
        this.limitCondition = limitCondition;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public int getPeriodOne() {
        return periodOne;
    }

    public void setPeriodOne(int periodOne) {
        this.periodOne = periodOne;
    }

    public int getPeriodTwo() {
        return periodTwo;
    }

    public void setPeriodTwo(int periodTwo) {
        this.periodTwo = periodTwo;
    }

    public int getCarrerProspects() {
        return carrerProspects;
    }

    public void setCarrerProspects(int carrerProspects) {
        this.carrerProspects = carrerProspects;
    }

    public double getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(int salaryOne) {
        this.salaryOne = salaryOne;
    }

    public double getSalaryTwo() {
        return salaryTwo;
    }

    public void setSalaryTwo(int salaryTwo) {
        this.salaryTwo = salaryTwo;
    }

    public double getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(int salaryThree) {
        this.salaryThree = salaryThree;
    }
}
