package dev.damola.fullstacktest.service;

import dev.damola.fullstacktest.UserInfoDto;
import dev.damola.fullstacktest.exceptions.NotfoundException;
import dev.damola.fullstacktest.model.Sector;
import dev.damola.fullstacktest.model.UserInfo;
import dev.damola.fullstacktest.model.UserSector;
import dev.damola.fullstacktest.repository.SectorRepository;
import dev.damola.fullstacktest.repository.UserInfoRepository;
import dev.damola.fullstacktest.repository.UserSectorRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserInfoService {
    @Autowired
    SectorRepository sectorRepository;
    @Autowired
    UserInfoRepository userInfoRepository;
    public Map<String, Object> storeUserInfo(UserInfoDto userInfoDto) throws Exception {
        try{
            UserInfo userInfo = new UserInfo();
            userInfo.setName(userInfoDto.name());
            userInfo.setAgreeToTerms(userInfoDto.agreeToTerms());
            List<UserSector> sectorList = userInfoDto.selectedSectors().stream().map(sectorId->{
                Sector sector= sectorRepository.findById(sectorId).orElseThrow(()->
                        new NotfoundException("sector not found"));
                return new UserSector(userInfo,sector);
            }).toList();
            userInfo.setSelectedSectors(sectorList);
            UserInfo savedUserInfo = userInfoRepository.save(userInfo);
            String  successString = "UserInfo saved successfully";
            Map<String, Object> newMap = new HashMap<>();
            newMap.put("message", successString);
            newMap.put("data", savedUserInfo);
            return newMap;
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }


}
