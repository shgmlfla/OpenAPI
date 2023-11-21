package com.example.openapi.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class TourInfoBody {

    private Long id;
    private String overview; // 개요
    private String phoneNumber; // 전화번호
    private String address; //도로명 주소
    private String dayOff; //휴무
    private String admissionFee; //입장료
    private String homepage; //홈페이지
    private String operatingHours;//이용시간
    private String parkingAvailability; //주차유무

    public TourInfoBody(Long id, String overview, String phoneNumber, String address, String dayOff, String admissionFee,
                        String homepage, String operatingHours, String parkingAvailability
    ){
        this.id = id;
        this.overview = overview;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dayOff = dayOff;
        this.admissionFee = admissionFee;;
        this.homepage = homepage;
        this.operatingHours = operatingHours;
        this.parkingAvailability = parkingAvailability;
    }
}
