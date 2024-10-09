package com.buyogo.Traini8.Controller;

import com.buyogo.Traini8.DTO.TrainingCenterDTO;
import com.buyogo.Traini8.Model.TrainingCenter;
import com.buyogo.Traini8.Service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trainingCentre")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping("/addCenter")
    public ResponseEntity<?> createCenter(@Valid @RequestBody TrainingCenterDTO center)  {
        {
            try{
                TrainingCenter savedCenter = trainingCenterService.addCenter(center);
                return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
            }catch (Exception ex) {

                Map<String, List<String>> errorResponse = new HashMap<>();
                List<String> list = List.of("FAILED TO CREATE TRAINING CENTER", "", "Please check following validations :", "1.CenterName must be less than 40 characters."
                ,  "2.CenterCode must be exactly 12 character alphanumeric. ",  "3.Email should be valid.", "4.Phone number must be 10 digits.");
                errorResponse.put("error", list);

                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @GetMapping("/getAllCenters")
    public ResponseEntity<List<TrainingCenter>> getAllCenters() {
        List<TrainingCenter> centers = trainingCenterService.getAllCenters();
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }

    @GetMapping("/getCenterByState")
    public ResponseEntity<List<TrainingCenter>> getCentersByState(@RequestParam String state) {
        List<TrainingCenter> centers = trainingCenterService.getCentersByState(state);
        return ResponseEntity.ok(centers);
    }

    @GetMapping("/getCenterByCity")
    public ResponseEntity<List<TrainingCenter>> getCentersByCity(@RequestParam String city) {
        List<TrainingCenter> centers = trainingCenterService.getCentersByCity(city);
        return ResponseEntity.ok(centers);
    }
}
