package com.banque.misr.irrigation.system.constant;

import lombok.Getter;

@Getter
public enum Tractor {
    Garden(0), Military(1), Autonomous(2);
    private final int id;

    Tractor(int id) {
        this.id = id;
    }
}
