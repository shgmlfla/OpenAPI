package com.example.openapi.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BestUlsan {

    private Long id;
    private String base;
    private String travelName;

    public BestUlsan(Long id, String base, String travelName){
        this.id = id;
        this.base = base;
        this.travelName = travelName;
    }
}
