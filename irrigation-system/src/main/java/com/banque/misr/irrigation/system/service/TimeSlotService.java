package com.banque.misr.irrigation.system.service;

import com.banque.misr.irrigation.system.entity.TimeSlot;

public interface TimeSlotService {

    TimeSlot createIfNotExistTimeSlot(com.banque.misr.irrigation.system.constant.TimeSlot timeSlot);

}
