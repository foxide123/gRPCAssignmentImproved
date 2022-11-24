package com.assignment.client.dto.third_station;

import java.util.List;

public class PartPackDto {
    Long regNr;
    List<Long> trayRef;


    public PartPackDto() {

    }

    public PartPackDto(Long regNr, List<Long> trayRef) {
        this.regNr = regNr;
        this.trayRef = trayRef;
    }

    public Long getRegNr() {
        return regNr;
    }

    public void setRegNr(Long regNr) {
        this.regNr = regNr;
    }

    public List<Long> getTrayRef() {
        return trayRef;
    }

    public void setTrayRef(List<Long> trayRef) {
        this.trayRef = trayRef;
    }
}
