package com.example.openapi.Service;

import com.example.openapi.Entity.BestUlsan;
import com.example.openapi.Entity.TourInfoBody;
import com.example.openapi.Entity.TourInfoHeader;
import com.example.openapi.Repository.UlsanRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.openapi.Entity.Ulsan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UlsanService {

    @Autowired
    private UlsanRepository ulsanRepository;

    // Best 조회
    public List<BestUlsan> getBestUlsanTour(){
        List<BestUlsan> BestUlsanTourBest = ulsanRepository.getBestUlsan();
        return BestUlsanTourBest;
    }

    public List<TourInfoHeader> getTourInfoHeader(Long Id){
        List<TourInfoHeader> tourInfoHeaders = ulsanRepository.findTourInfoHeader(Id);
        return tourInfoHeaders;
    }

    public List<TourInfoBody> getTourInfoBody(Long Id){
        List<TourInfoBody> tourInfoBodies = ulsanRepository.findTourInfoBody(Id);
        return tourInfoBodies;
    }
    public void saveUlsanData(String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            JsonNode dataArray = jsonNode.get("data");
            if (dataArray != null && dataArray.isArray()) {
                for (JsonNode ulsanNode : dataArray) {
                    saveUlsanDataInternal(ulsanNode.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUlsanDataInternal(String ulsanJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Ulsan ulsan = objectMapper.readValue(ulsanJson, Ulsan.class);
            ulsanRepository.save(ulsan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
