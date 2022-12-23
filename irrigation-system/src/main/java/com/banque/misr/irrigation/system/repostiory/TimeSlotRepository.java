package com.banque.misr.irrigation.system.repostiory;

import com.banque.misr.irrigation.system.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {

    Optional<TimeSlot> findBySlotAndSlotDay(com.banque.misr.irrigation.system.constant.TimeSlot timeSlot, Date slotDay);

}
