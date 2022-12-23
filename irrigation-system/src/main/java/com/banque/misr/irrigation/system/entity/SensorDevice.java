package com.banque.misr.irrigation.system.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SENSOR_DEVICE")
@Data
public class SensorDevice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "available")
    private boolean available;


}
