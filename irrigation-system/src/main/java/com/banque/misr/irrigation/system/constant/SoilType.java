package com.banque.misr.irrigation.system.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum SoilType {
    SANDY("sandy", 10, 0),
    SILT("silt", 5, 1),
    CLAY_SOIL("clay_soil", 2, 2),
    LOAMY("loamy", 7, 2);

    private final String type;
    private final double waterNeedPerMeter;
    private final int id;

    SoilType(String type, double waterNeedPerMeter, int id) {
        this.type = type;
        this.waterNeedPerMeter = waterNeedPerMeter;
        this.id = id;
    }

    public static Optional<SoilType> getById(int value) {
        return Arrays.stream(SoilType.values())
                .filter(soilType -> soilType.id == value)
                .findFirst();
    }

}
