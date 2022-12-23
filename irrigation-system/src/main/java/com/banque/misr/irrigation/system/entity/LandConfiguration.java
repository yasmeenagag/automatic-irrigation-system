package com.banque.misr.irrigation.system.entity;

import com.banque.misr.irrigation.system.constant.AgriculturalCrop;
import com.banque.misr.irrigation.system.constant.Insecticide;
import com.banque.misr.irrigation.system.constant.TimeSlot;
import com.banque.misr.irrigation.system.constant.Tractor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "LAND_CONFIGUARTION")
@Data
public class LandConfiguration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "agricultural_crop")
    private AgriculturalCrop agriculturalCrop;

    @Column(name = "insecticide")
    private Insecticide insecticide;

    @Column(name = "tractor")
    private Tractor tractor;

    @Column(name = "time_slot")
    private TimeSlot timeSlot;

    @Column(name = "needed_amount_of_water")
    private Long neededAmountOfWater;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "land_id", referencedColumnName = "id")
    private Land land;

    @Override
    public String toString() {
        return "LandConfiguration{" +
                "id=" + id +
                ", agriculturalCrop=" + agriculturalCrop +
                ", insecticide=" + insecticide +
                ", tractor=" + tractor +
                '}';
    }

}
