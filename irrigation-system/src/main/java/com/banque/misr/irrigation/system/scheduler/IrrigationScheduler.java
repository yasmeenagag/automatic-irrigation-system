package com.banque.misr.irrigation.system.scheduler;

import com.banque.misr.irrigation.system.constant.TimeSlot;
import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.serviceimpl.IrrigationServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class IrrigationScheduler {
    private final IrrigationServiceImpl irrigationService;

    public IrrigationScheduler(IrrigationServiceImpl irrigationService) {
        this.irrigationService = irrigationService;
    }


    // for testing
    @Scheduled(cron = "${every.minute.cron.expression}")
   // @Scheduled(cron = "${every.twelve.hours.cron.expression}")
    public void startIrrigate() {
        irrigationService.startIrrigation();
           }

}
