package dev.damola.fullstacktest.controller;

import dev.damola.fullstacktest.UserInfoDto;
import dev.damola.fullstacktest.service.UserInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/userInfo")
@CrossOrigin(origins = "http://localhost:3000")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping()
    public ResponseEntity<?> addUserInfo(@RequestBody @Valid UserInfoDto userInfoDto) throws Exception {
        Map<String, Object> result = userInfoService.storeUserInfo(userInfoDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
