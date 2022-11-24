package com.assignment.server.dao.second_station;

import com.assignment.server.dao.third_station.PartPackDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tray")
public class TrayDao {

    @Id
    @Column(name="reg_nr")
    Long regNr;
    @Column(name="weight")
    float weight;
    @Column(name="part_type")
    String partType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="part_ref")
    List<AnimalPartDao> partRef;


    public TrayDao() {
    }

    public TrayDao(Long regNr, float weight, String partType, List<AnimalPartDao> partRef) {
        this.regNr = regNr;
        this.weight = weight;
        this.partType = partType;
        this.partRef = partRef;
    }

    public Long getRegNr() {
        return regNr;
    }

    public void setRegNr(Long regNr) {
        this.regNr = regNr;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public List<AnimalPartDao> getPartRef() {
        return partRef;
    }

    public void setPartRef(List<AnimalPartDao> partRef) {
        this.partRef = partRef;
    }
}
