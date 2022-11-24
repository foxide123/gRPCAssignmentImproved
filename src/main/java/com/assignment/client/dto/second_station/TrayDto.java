package com.assignment.client.dto.second_station;



import java.util.List;

public class TrayDto {
    private Long regNr;
    private float weight;
    String partType;
    private List<Long> partRef;

    public TrayDto()
    {

    }

    public TrayDto(Long regNr, float weight, String partType, List<Long> partRef) {
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

    public List<Long> getPartRef() {
        return partRef;
    }

    public void setPartRef(List<Long> partRef) {
        this.partRef = partRef;
    }
}
