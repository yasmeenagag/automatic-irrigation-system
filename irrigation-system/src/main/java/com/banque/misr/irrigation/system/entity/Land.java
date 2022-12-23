package com.banque.misr.irrigation.system.entity;


import com.banque.misr.irrigation.system.constant.SoilType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LAND")
@Data
public class Land {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "soil_type")
    private SoilType soilType;

    @Column(name = "irrigated_at")
    private Date irrigatedAt;

    @Column(name = "area")
    private Long area;

    @OneToOne(mappedBy = "land")
    private LandConfiguration landConfiguration;

    @Override
    public String toString() {
        return "Land{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", soilType=" + soilType +
                ", irrigatedAt=" + irrigatedAt +
                ", area=" + area +
                '}';
    }

}
