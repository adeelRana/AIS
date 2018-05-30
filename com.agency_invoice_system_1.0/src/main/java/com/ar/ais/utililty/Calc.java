/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.utililty;

import com.ar.ais.enums.DiscountType;
import com.ar.ais.models.EntityBeans.Shop;

/**
 *
 * @author Adi Rana
 */
public class Calc {

    public static double getDiscount(double amount, Shop s) {
        switch (s.getDiscountType()) {
            case DiscountType.AGENCY_PER:
                return (amount * s.getDiscountAgency() / 100);
            case DiscountType.DISTRIBUTOR_PER:
                return (amount * s.getDiscountDistributor() / 100);
            case DiscountType.JOINED_PER:
                return (amount * (s.getDiscountAgency() + s.getDiscountDistributor()) / 100);

            case DiscountType.AGENCY_RS:
                return s.getDiscountAgency();
            case DiscountType.DISTRIBUTOR_RS:
                return s.getDiscountDistributor();
            case DiscountType.JOINED_RS:
                return (s.getDiscountAgency() + s.getDiscountDistributor());
            default:
                return amount;
        }
    }

    public static double lessDiscount(double amount, Shop s) {
        return amount - getDiscount(amount, s);
    }

}
