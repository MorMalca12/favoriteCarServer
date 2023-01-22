package com.intango.favoritecar.car;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import javax.persistence.OrderBy;


@Entity
public class Car {


    @GeneratedValue
    @Id
    private long id;

    private String imgName;

    private int votesNumber;

    public Car(String imgName, int votesNumber) {
        this.imgName = imgName;
        this.votesNumber = votesNumber;
    }

    public Car() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }


    public int getVotesNumber() {
        return votesNumber;
    }

    public void setVotesNumber(int votesNumber) {
        this.votesNumber = votesNumber;
    }
}
