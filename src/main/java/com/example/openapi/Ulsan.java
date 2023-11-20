package com.example.openapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
public class Ulsan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //개요
    @JsonProperty("개요")
    private String overview;

    @JsonProperty("개장기간")
    private String openingPeriod;

    @JsonProperty("경도값")
    private String longitude;

    @JsonProperty("관람소요시간")
    private String requiredTime;

    @JsonProperty("광역")
    private String region;

    @JsonProperty("기초")
    private String base;

    @JsonProperty("대구분")
    private String category;

    @JsonProperty("도로명주소")
    private String address;

    @JsonProperty("소구분")
    private String subCategory;

    @JsonProperty("신용카드 가능여부")
    private String creditCardAvailable;

    @JsonProperty("아이디(ID)")
    private String userId;

    @JsonProperty("애완동물 동반가능여부")
    private String petAccompany;

    @JsonProperty("여행지명")
    private String travelName;

    @JsonProperty("예약안내")
    private String reservationInfo;

    @JsonProperty("온라인안내")
    private String onlineInfo;

    @JsonProperty("운영정보기타")
    private String operationInfo;

    @JsonProperty("위도값")
    private String latitude;

    @JsonProperty("이용시간")
    private String operatingHours;

    @JsonProperty("입장료_시설이용료")
    private String admissionFee;

    @JsonProperty("전화번호")
    private String phoneNumber;

    @JsonProperty("주차요금")
    private String parkingFee;

    @JsonProperty("주차유무")
    private String parkingAvailability;

    @JsonProperty("중구분")
    private String mainCategory;

    @JsonProperty("지정현황")
    private String designationStatus;

    @JsonProperty("참고페이지")
    private String referencePage;

    @JsonProperty("체험가능연령(이용가능연령)")
    private String experienceAge;

    @JsonProperty("체험프로그램")
    private String experienceProgram;

    @JsonProperty("촬영장소")
    private String shootingLocation;

    @JsonProperty("한줄정보")
    private String briefInfo;

    @JsonProperty("현장음성지원")
    private String onSiteAudioSupport;

    @JsonProperty("홈페이지")
    private String homepage;

    @JsonProperty("휴무")
    private String dayOff;
}
