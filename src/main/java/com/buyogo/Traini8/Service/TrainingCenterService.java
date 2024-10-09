package com.buyogo.Traini8.Service;

import com.buyogo.Traini8.DTO.TrainingCenterDTO;
import com.buyogo.Traini8.Model.Address;
import com.buyogo.Traini8.Model.TrainingCenter;
import com.buyogo.Traini8.Repository.TrainingCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCentreRepository trainingCentreRepository;

    public TrainingCenter addCenter(TrainingCenterDTO trainingCenter) {

        TrainingCenter center = TrainingCenter.builder()
                .centerCode(trainingCenter.getCenterCode())
                .centerName(trainingCenter.getCenterName())
                .address(trainingCenter.getAddress())
                .contactEmail(trainingCenter.getContactEmail())
                .contactPhone(trainingCenter.getContactPhone())
                .coursesOffered(trainingCenter.getCoursesOffered())
                .studentCapacity(trainingCenter.getStudentCapacity())
                .build();

        return trainingCentreRepository.save(center);
    }

    public List<TrainingCenter> getAllCenters() {
        return trainingCentreRepository.findAll();
    }

    public List<TrainingCenter> getCentersByState(String state) {
        return trainingCentreRepository.findCentersByState(state);
    }

    public List<TrainingCenter> getCentersByCity(String city) {
        List<TrainingCenter> trainingCenters = trainingCentreRepository.findAll();
        List<TrainingCenter> centerList = new ArrayList<>();

        for (TrainingCenter trainingCenter : trainingCenters)
        {
            Address address = trainingCenter.getAddress();
            if(address.getCity().equals(city))
                centerList.add(trainingCenter);
        }
        return centerList;
    }
}
