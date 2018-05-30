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
public enum CrType {

    INVOICE_CR((short) 1),
    HAND_CR((short) 2);

    private final int value;
    private static final Map<Short, CrType> STATUS_MAP = new HashMap<Short, CrType>();

    static {
        for (CrType s : values()) {
            STATUS_MAP.put(s.getValue(), s);
        }
    }

    private CrType(short value) {
        this.value = value;
    }

    public short getValue() {
        return Short.parseShort(value + "");
    }

    public static CrType get(short val) {
        return STATUS_MAP.get(val);
    }

};
