package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.entity.SensorDevice;
import com.banque.misr.irrigation.system.exception.SensorNotAvailableException;
import com.banque.misr.irrigation.system.repostiory.SensorDeviceRepository;
import com.banque.misr.irrigation.system.service.SensorDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SensorDeviceServiceImpl implements SensorDeviceService {

    private final SensorDeviceRepository sensorDeviceRepository;

    public SensorDeviceServiceImpl(SensorDeviceRepository sensorDeviceRepository) {
        this.sensorDeviceRepository = sensorDeviceRepository;
    }

    @Retryable(value = SensorNotAvailableException.class, maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    public SensorDevice getSensorDevice(Long id )  throws SensorNotAvailableException{
        return sensorDeviceRepository.findByIdAndAvailable(id, true).orElseThrow(
                () -> new SensorNotAvailableException("Not available"));
    }

    @Recover
    public SensorDevice recover(SensorNotAvailableException e , Long id) {
        log.error("Sensor device not found ");
        return null;
    }

    @Override
    public void startIrrigation(List<Land> landsToBeIrrigated) {
        // check if sensor available
        SensorDevice sensorDevice = getSensorDevice(1L);

        landsToBeIrrigated.forEach(
                land -> {
                    land.setIrrigatedAt(new Date());
                    log.info(land.getName() + " is irrigated at " + land.getIrrigatedAt());
                }
        );
    }

}
