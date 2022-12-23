package com.banque.misr.irrigation.system.constant;

import lombok.Getter;

@Getter
public enum Insecticide {
    Organic(0), Synthetic(1), Inorganic(2), Miscellaneous(3);

    private final int id;

    Insecticide(int i) {
        this.id = i;
    }

}
