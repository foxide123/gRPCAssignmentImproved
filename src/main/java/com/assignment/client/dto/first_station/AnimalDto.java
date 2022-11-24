package com.assignment.client.dto.first_station;

import javax.persistence.Column;
import javax.persistence.Id;

public class AnimalDto {

    private long regNr;
    private String arriveDate;
    private float weight;
    private String origin;


    public AnimalDto()
    {

    }
    public AnimalDto(long regNr, String arriveDate, float weight, String origin)
    {
        this.regNr = regNr;
        this.arriveDate = arriveDate;
        this.weight = weight;
        this.origin = origin;
    }

    public long getRegNr() {
        return regNr;
    }

    public void setRegNr(long regNr) {
        this.regNr = regNr;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
