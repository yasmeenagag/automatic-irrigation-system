package com.banque.misr.irrigation.system.service;

import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.entity.SensorDevice;
import com.banque.misr.irrigation.system.exception.SensorNotAvailableException;

import java.util.List;

public interface SensorDeviceService {

    SensorDevice getSensorDevice( Long id);

    SensorDevice recover(SensorNotAvailableException e, Long id);

    void startIrrigation(List<Land> landsToBeIrrigated);

}
