package dev.damola.fullstacktest.controller;

import dev.damola.fullstacktest.service.SectorService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sectors")
@CrossOrigin(origins = "*")
public class SectorController {
    @Autowired
    SectorService sectorService;
    @GetMapping
    public ResponseEntity<?> getAllSectors(){
        var result = sectorService.getAllSectors();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
