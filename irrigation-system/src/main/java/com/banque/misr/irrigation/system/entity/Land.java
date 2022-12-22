package com.banque.misr.irrigation.system.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LAND")
@Data
public class Land {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "area")
    private String area;

    @Column(name = "location")
    private String location;

    @Column(name = "agricultural_crop")
    private String agriculturalCrop;

    @Column(name = "irrigated_at")
    private Date irrigatedAt;

}
