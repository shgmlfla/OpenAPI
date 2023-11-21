package com.example.openapi.Controller;


import com.example.openapi.Entity.BestUlsan;
import com.example.openapi.Entity.TourInfoBody;
import com.example.openapi.Entity.TourInfoHeader;
import com.example.openapi.Service.UlsanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/ulsanTour")
public class UlsanApiController {

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Autowired
    private UlsanService ulsanService;

    @GetMapping("/bestUlsanTour")
    public List<BestUlsan> bestTour(){
        List<BestUlsan> bestUlsanTourList = ulsanService.getBestUlsanTour();
        return bestUlsanTourList;
    }

    // 아이디 값 조회하면 하나.
    @GetMapping("/tourInformation/header/{id}")
    public List<TourInfoHeader> TourInfoHeader(@PathVariable("id") Long Id){
        List<TourInfoHeader> tourInfoHeaders = ulsanService.getTourInfoHeader(Id);
        return tourInfoHeaders;
    }

    // 아이디값 조회하면 하나
    @GetMapping("/tourInformation/body/{id}")
    public List<TourInfoBody> TourInfoBody(@PathVariable("id") Long Id){
        List<TourInfoBody> tourInfoBodies = ulsanService.getTourInfoBody(Id);
        return tourInfoBodies;
    }

    @GetMapping("/ulsanapi")
    public String UlsanTestController(
            @RequestParam(value="page") int page,
            @RequestParam(value="perPage") int perPage,
            @RequestParam(value="returnType") String returnType
    ){
        StringBuffer result = new StringBuffer();
        try{
            String urlstr = "https://api.odcloud.kr/api/15111043/v1/uddi:792cbe52-6ca6-4b62-8c2d-8081bc6ad12b?" +
                    "&page=" + page +
                    "&perPage=" + perPage +
                    "&returnType=" + returnType +
                    "&serviceKey=" + serviceKey;
            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while((returnLine = br.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }

        String stringResult = result.toString();
        ulsanService.saveUlsanData(stringResult);
        System.out.println("resultType : " + result.getClass().getName());
        return result.toString();
    }

}
