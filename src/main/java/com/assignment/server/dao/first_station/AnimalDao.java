package com.assignment.server.dao.first_station;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class AnimalDao {
    @Id
    @Column(name="reg_nr")
    private long regNr;
    @Column(name="arrive_date")
    private String arriveDate;
    @Column(name="weight")
    private float weight;
    @Column(name="origin")
    private String origin;


    public AnimalDao()
    {

    }
    public AnimalDao(long regNr, String arriveDate, float weight, String origin)
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
