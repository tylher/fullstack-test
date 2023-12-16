package dev.damola.fullstacktest.service;

import dev.damola.fullstacktest.UserInfoDto;
import dev.damola.fullstacktest.exceptions.NotfoundException;
import dev.damola.fullstacktest.model.Sector;
import dev.damola.fullstacktest.model.UserInfo;
import dev.damola.fullstacktest.model.UserSector;
import dev.damola.fullstacktest.repository.SectorRepository;
import dev.damola.fullstacktest.repository.UserInfoRepository;
import dev.damola.fullstacktest.repository.UserSectorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoService {
    Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);
    @Autowired
    SectorRepository sectorRepository;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserSectorRepository userSectorRepository;
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

public Map<String, Object> getAllUsersInfo(){
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        Map<String, Object> newMap = new HashMap<>();
        String successString = "users info fetched successfully";
        newMap.put("message", successString);
        newMap.put("data", userInfoList);
        return newMap;
}

    @Transactional
    public Map<String, Object> editUserInfo(String userId, UserInfoDto userInfoDto) throws Exception {
        try{
            UserInfo savedUserInfo = userInfoRepository.findById(userId)
                    .orElseThrow(()->new NotfoundException("user info not found"));
            savedUserInfo.getSelectedSectors().forEach(sector-> sector.setUserInfo(null));
           savedUserInfo.getSelectedSectors().clear();
            List<UserSector> sectorList = userInfoDto.selectedSectors().stream().map(sectorId->{
                Sector sector= sectorRepository.findById(sectorId).orElseThrow(()->
                        new NotfoundException("sector not found"));
                return new UserSector(savedUserInfo,sector);
            }).toList();

            for(UserSector sector:sectorList){
                sector.setUserInfo(savedUserInfo);
                savedUserInfo.getSelectedSectors().add(sector);
                userSectorRepository.save(sector);
            }

            LOGGER.info("updating user info");
            savedUserInfo.setName(userInfoDto.name());
            savedUserInfo.setAgreeToTerms(userInfoDto.agreeToTerms());
            LOGGER.info("set all properties");

            UserInfo userInfo = userInfoRepository.save(savedUserInfo);
            Map<String, Object> newMap = new HashMap<>();
            String successString = "User info updated successfully";
            newMap.put("message",successString);
            newMap.put("data", userInfo);
            return  newMap;

        }
        catch (Exception ex){
            throw new Exception("could not edit user info: "+ ex.getMessage());
        }
    }
}
