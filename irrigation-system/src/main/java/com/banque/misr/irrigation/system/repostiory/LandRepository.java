package com.banque.misr.irrigation.system.repostiory;

import com.banque.misr.irrigation.system.constant.TimeSlot;
import com.banque.misr.irrigation.system.entity.Land;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LandRepository extends JpaRepository<Land , Long> {

    @Override
    Page<Land> findAll(Pageable pageable);

    List<Land> findAllByLandConfiguration_TimeSlot(TimeSlot timeSlot);

}
