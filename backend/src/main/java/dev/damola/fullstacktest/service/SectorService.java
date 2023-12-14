package dev.damola.fullstacktest.service;

import dev.damola.fullstacktest.model.Sector;
import dev.damola.fullstacktest.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SectorService {
    @Autowired
    SectorRepository sectorRepository;
    public Map<String, Object> getAllSectors(){
        List<Sector> sectorList= sectorRepository.findAll();
        String  successString = "Sectors fetched successfully";
        Map<String, Object> newMap = new HashMap<>();
        newMap.put("message", successString);
        newMap.put("data", sectorList);
        return newMap;
    }
}
