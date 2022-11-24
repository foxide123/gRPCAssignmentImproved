package com.assignment.server.dao.third_station;

import com.assignment.server.dao.second_station.TrayDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="part_pack")
public class PartPackDao {
    @Id
    @Column(name="reg_nr")
    Long regNr;
    //CascadeType.ALL -The meaning of CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="tray_ref")
    List<TrayDao> trayRef;

    public PartPackDao() {
    }

    public PartPackDao(Long regNr, List<TrayDao> trayRef) {
        this.regNr = regNr;
        this.trayRef = trayRef;
    }

    public Long getRegNr() {
        return regNr;
    }

    public void setRegNr(Long regNr) {
        this.regNr = regNr;
    }

    public List<TrayDao> getTrayRef() {
        return trayRef;
    }

    public void setTrayRef(List<TrayDao> trayRef) {
        this.trayRef = trayRef;
    }
}
