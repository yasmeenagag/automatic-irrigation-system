package com.banque.misr.irrigation.system.repostiory;

import com.banque.misr.irrigation.system.entity.SensorDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorDeviceRepository extends JpaRepository<SensorDevice, Long> {

    Optional<SensorDevice> findByIdAndAvailable(long id, boolean available);

}
