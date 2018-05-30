/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.utililty;

import java.text.DecimalFormat;

/**
 *
 * @author Adi Rana
 */
public class Frmttr {

    public static final String WEIGHT_IN_GM = "#0 gm";
    public static final String WEIGHT_IN_TN = "#0.000 tons";
    public static final String WEIGHT_IN_KG = "#0.00 Kgs";
    public static final String SIMPLE_NUMBER = "#0";
    public static final String RS = "Rs #0.00";

    private static DecimalFormat f;

    public static String Format(Number n, String format) {
        
        if (null != n) {
            f = new DecimalFormat(format);
            return f.format(n);
        }
        return "";
    }

    public static double getDoubleFromString(String value) {
        try {
            return Double.parseDouble(value.replaceAll("[^(\\d+\\.\\d+)]", ""));
        } catch (NullPointerException | NumberFormatException e) {
            return 0;
        }
    }

    public static int getIntFromDouble(Double value) {
        try {
            return Integer.parseInt(Format(value, SIMPLE_NUMBER));
        } catch (NullPointerException | NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("" + Frmttr.Format(2460.6, SIMPLE_NUMBER));
    }
}
