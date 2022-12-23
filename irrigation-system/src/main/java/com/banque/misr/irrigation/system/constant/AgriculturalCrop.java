package com.banque.misr.irrigation.system.constant;

import lombok.Getter;

@Getter
public enum AgriculturalCrop {
    Corn(0), Soy(1), Hay(2), Wheat(3), Cotton(4);

    private final int id ;
    AgriculturalCrop(int id) {
        this.id=id;
    }
}
