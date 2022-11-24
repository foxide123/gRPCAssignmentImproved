package com.assignment.server.dao.second_station;

import com.assignment.server.dao.third_station.PartPackDao;

import javax.persistence.*;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="part_ref", referencedColumnName="reg_nr")
    AnimalPartDao partRef;

    @ManyToOne
    @JoinColumn(name="part_pack_ref")
    private PartPackDao partPack;


    public TrayDao() {
    }

    public TrayDao(Long regNr, float weight, String partType, AnimalPartDao partRef) {
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

    public AnimalPartDao getPartRef() {
        return partRef;
    }

    public void setPartRef(AnimalPartDao partRef) {
        this.partRef = partRef;
    }
}
