package com.banque.misr.irrigation.system.service;

import com.banque.misr.irrigation.system.entity.TimeSlot;

public interface TimeSlotService {

    TimeSlot createTimeSlotIfNotExist(com.banque.misr.irrigation.system.constant.TimeSlot timeSlot);

    void save(TimeSlot timeSlotEntity);

}
