package com.buyogo.Traini8.Repository;

import com.buyogo.Traini8.Model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCentreRepository extends JpaRepository<TrainingCenter, Integer> {

    @Query("SELECT tc FROM TrainingCenter tc WHERE tc.address.state = :state")
    List<TrainingCenter> findCentersByState(@Param("state") String state);
}
