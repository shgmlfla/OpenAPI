package com.example.openapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UlsanService_ver1 {

    @Autowired
    private UlsanRepository ulsanRepository;

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
