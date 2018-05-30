/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.db;

import com.ar.ais.models.EntityBeans.AppUser;
import com.ar.ais.models.EntityBeans.WorkingSchedule;
import com.ar.ais.models.Login;

/**
 *
 * @author Adeel rana
 */
public class DbmUtils {

    public boolean isUserExist(String userName, Number userId, boolean isIdIncluded) {
        if (isIdIncluded) {
            String query = "SELECT u FROM AppUser u WHERE u.userName = '" + userName + "' AND u.userId !=  '" + userId + "'";
            return !DBM.getRecordsFromQuery(query).isEmpty();
        } else {
            return !DBM.getRecordsBy(AppUser.class, "UserName", userName).isEmpty();
        }
    }

    public boolean isWorkingScheduleExist(WorkingSchedule ws) {
        return !DBM.getRecordsBy(WorkingSchedule.class, "Date", ws.getDate()).isEmpty();
    }

    public boolean islogedIn(Login login) {
        String query = "SELECT u FROM AppUser u WHERE u.userName = '" + login.getUserName() + "' AND u.userPass=   '" + login.getPassword() + "'";
        return !DBM.getRecordsFromQuery(query).isEmpty();
    }

//////////////////////////////////////////////////////////////////////////////////////////
//    public boolean isProductExist(Products product) {
//        String query = "SELECT p FROM Products p WHERE p.code = '" + product.getCode() + "' ";
////                + "AND ( p.typeId = '" + product.getTypeId() + "' AND p.vehicleId = '" + product.getVehicleId() + "' "
////                + "AND p.locationId = '" + product.getLocationId() + "' )";
//        return !DBM.getRecordsFromQuery(query).isEmpty();
//    }
//
// public static int addLocation(Location location) {
//        if (!location.getName().isEmpty()) {
//            if (JOptionPane.showConfirmDialog(null, "Location \"" + location.getName() + "\" Does not exist. \n Do you want to add new ") == 0) {
//                return ((Location) DBM.insertRecords(Location.class, location)).getId();
//            }
//        }
//        return 0;
//    }
//
//    public Products getProduct(Products product) {
//        String query = "SELECT p FROM Products p WHERE p.code = '" + product.getCode() + "' "
//                + "AND ( p.type = '" + product.getTypeId() + "' AND p.vehicleId = '" + product.getVehicleId() + "' "
//                + "AND p.locationId = '" + product.getLocationId() + "' )";
//        return (Products) DBM.getRecordsFromQuery(query).get(0);
//    }
}
