/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adi Rana
 */
public enum Status {

    IN_ACTIVE((short) 0),
    ACTIVE((short) 1),
    CLOSED((short) 2),
    PAYBLE((short) 3),
    PAID((short) 4),
    RECEIVEABLE((short) 5),
    RECEIVED((short) 6),
    LOCKED((short) 7),
    OUT_OF_STOCK((short) 8);

    private final int value;
    private static final Map<Short, Status> STATUS_MAP = new HashMap<Short, Status>();

    static {
        for (Status s : values()) {
            STATUS_MAP.put(s.getValue(), s);
        }
    }

    private Status(short value) {
        this.value = value;
    }

    public short getValue() {
        return Short.parseShort(value + "");
    }

    public static Status get(short val) {
        return STATUS_MAP.get(val);
    }

};
