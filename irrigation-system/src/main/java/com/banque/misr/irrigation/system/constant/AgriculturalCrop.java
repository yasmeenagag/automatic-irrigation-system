package com.banque.misr.irrigation.system.constant;

import lombok.Getter;

@Getter
public enum AgriculturalCrop {
    CORN(0), SOY(1), HAY(2), WHEAT(3), COTTON(4);

    private final int id ;
    AgriculturalCrop(int id) {
        this.id=id;
    }
}
