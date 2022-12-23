package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.constant.TimeSlot;
import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.entity.SensorDevice;
import com.banque.misr.irrigation.system.service.IrrigationService;
import com.banque.misr.irrigation.system.service.LandService;
import com.banque.misr.irrigation.system.service.SensorDeviceService;
import com.banque.misr.irrigation.system.service.TimeSlotService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class IrrigationServiceImpl implements IrrigationService {

    private final LandService landService;
    private final TimeSlotService timeSlotService;
    private final SensorDeviceService sensorDeviceService;

    public IrrigationServiceImpl(LandService landService, TimeSlotService timeSlotService, SensorDeviceService sensorDeviceService) {
        this.landService = landService;
        this.timeSlotService = timeSlotService;
        this.sensorDeviceService = sensorDeviceService;
    }

    public void startIrrigation() {
        // steps to start automatic irrigation
        LocalTime now = LocalTime.now();
        TimeSlot timeSlot = TimeSlot.Evening;
        int hour = now.getHour();
        if (hour >= 6 && hour < 18) {
            timeSlot = TimeSlot.Morning;
        }
        // get lands needs irrigation (time_slot)
        List<Land> landsToBeIrrigated = landService.landsToBeIrrigated(timeSlot);

        // create slot if not created
        com.banque.misr.irrigation.system.entity.TimeSlot timeSlotEntity = timeSlotService.createIfNotExistTimeSlot(timeSlot);

        SensorDevice sensorDevice = sensorDeviceService.getSensorDevice(1L);
        // check if sensor available

        // start irrigate

        // update status of time slot

        // update irrigated lands

    }

}
