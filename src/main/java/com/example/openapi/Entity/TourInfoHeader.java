package com.example.openapi.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TourInfoHeader {

    private Long id;
    private String base;
    private String travelName;
    private String briefInfo;
    public TourInfoHeader(Long id, String base, String travelName, String briefInfo){
        this.id = id;
        this.base = base;
        this.travelName = travelName;
        this.briefInfo = briefInfo;
    }


}
