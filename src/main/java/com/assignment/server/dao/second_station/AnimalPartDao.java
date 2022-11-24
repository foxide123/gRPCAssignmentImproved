package com.assignment.server.dao.second_station;

import com.assignment.server.dao.first_station.AnimalDao;

import javax.persistence.*;

@Entity
@Table(name="animal_part")
public class AnimalPartDao {
    @Id
    @Column(name="reg_nr")
    private Long regNr;
    @Column(name="type")
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="animal_ref", referencedColumnName="reg_nr")
    private AnimalDao animalRef;
    @Column(name="weight")
    float weight;


    public AnimalPartDao() {
    }

    public AnimalPartDao(Long regNr, String type, AnimalDao animalRef, float weight) {
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

    public AnimalDao getAnimalRef() {
        return animalRef;
    }

    public void setAnimalRef(AnimalDao animalRef) {
        this.animalRef = animalRef;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
