package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.entity.TimeSlot;
import com.banque.misr.irrigation.system.repostiory.TimeSlotRepository;
import com.banque.misr.irrigation.system.service.TimeSlotService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public TimeSlot createIfNotExistTimeSlot(com.banque.misr.irrigation.system.constant.TimeSlot timeSlot) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate todayLD = LocalDate.now();
        Date today = Date.from(todayLD.atStartOfDay(defaultZoneId).toInstant());
        // morning or evening slot per day
        Optional<TimeSlot> slot = timeSlotRepository.findBySlotAndSlotDay(timeSlot, today);
        if (slot.isPresent()) {
            return slot.get();
        }
        TimeSlot newSlot = new TimeSlot();
        newSlot.setSlotDay(today);
        newSlot.setSlot(timeSlot);
        newSlot.setStatus(false);
        return timeSlotRepository.save(newSlot);
    }

}
