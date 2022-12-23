package com.banque.misr.irrigation.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIME_SLOT")
@Data
public class TimeSlot {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "slot")
    private com.banque.misr.irrigation.system.constant.TimeSlot slot;

    @Column(name = "slot_day")
    private Date slotDay;

    @Column(name = "status")
    private boolean status;

}
