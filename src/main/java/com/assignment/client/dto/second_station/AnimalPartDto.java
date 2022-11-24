package com.assignment.client.dto.second_station;

import com.assignment.server.dao.first_station.AnimalDao;

import javax.persistence.*;

public class AnimalPartDto {

    private Long regNr;
    private String type;
    private Long animalRef;
    float weight;


    public AnimalPartDto() {
    }

    public AnimalPartDto(Long regNr, String type, Long animalRef, float weight) {
        this.regNr = regNr;
        this.type = type;
        this.animalRef = animalRef;
        this.weight = weight;
    }

    public Long getRegNr() {
        return regNr;
    }

    public void setRegNr(Long regNr) {
        this.regNr = regNr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAnimalRef() {
        return animalRef;
    }

    public void setAnimalRef(Long animalRef) {
        this.animalRef = animalRef;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
