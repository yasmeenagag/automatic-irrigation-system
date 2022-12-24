package com.banque.misr.irrigation.system.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum SoilType {
    Sandy(0),
    Slit(1),
    ClaySoil(2),
    Loamy(3);

    private final int id;

    SoilType(int id) {
        this.id = id;
    }
}
