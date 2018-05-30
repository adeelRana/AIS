/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.controller;

import com.ar.ais.db.InsertUtils;
import com.ar.ais.db.DBM;
import com.ar.ais.db.DbmUtils;
import com.ar.ais.db.UpdateUtils;
import com.ar.ais.enums.Status;
import com.ar.ais.models.EntityBeans.AppUser;
import com.ar.ais.models.EntityBeans.Booker;
import com.ar.ais.models.EntityBeans.BookerCr;
import com.ar.ais.models.EntityBeans.Company;
import com.ar.ais.models.EntityBeans.Invoice;
import com.ar.ais.models.EntityBeans.Products;
import com.ar.ais.models.EntityBeans.Route;
import com.ar.ais.models.EntityBeans.Shop;
import com.ar.ais.models.EntityBeans.Stock;
import com.ar.ais.models.EntityBeans.Summary;
import com.ar.ais.models.EntityBeans.Transactions;
import com.ar.ais.models.EntityBeans.WorkingSchedule;
import com.ar.ais.models.Login;
import com.ar.ais.models.Response;
import com.ar.ais.utililty.Global;

/**
 *
 * @author Adeel rana
 */
public class InventryController implements ControllerInterface {

    DbmUtils dbmUtils = new DbmUtils();
    InsertUtils insertUtils = new InsertUtils();
    UpdateUtils updateUtils = new UpdateUtils();

    @Override
    public Response fetch(String param) {
        Response response = new Response();
        switch (param) {
            case "AppUser":
                response.setResponseObject(DBM.getAllRecords(AppUser.class));
                break;
            case "Company":
                response.setResponseObject(DBM.getAllRecords(Company.class));
                break;
            case "Products":
                response.setResponseObject(DBM.getAllRecords(Products.class));
                break;
            case "Route":
                response.setResponseObject(DBM.getAllRecords(Route.class));
                break;
            case "Booker":
                response.setResponseObject(DBM.getAllRecords(Booker.class));
                break;
            case "Shop":
                response.setResponseObject(DBM.getAllRecords(Shop.class));
                break;
            case "Stock":
                response.setResponseObject(DBM.getAllRecords(Stock.class));
                break;
            case "WorkingSchedule":
                response.setResponseObject(DBM.getAllRecords(WorkingSchedule.class));
                break;
            default:
                response.setError(true);
                response.setErrorMsg("Invalid Param");
        }
        return response;
    }

    @Override
    public Response fetchActive(String param) {
        Response response = new Response();
        switch (param) {

            case "Booker":
                response.setResponseObject(DBM.getRecordsBy(Booker.class, "Status", Status.ACTIVE.getValue()));
                break;
            case "Products":
                response.setResponseObject(DBM.getRecordsBy(Products.class, "Status", Status.ACTIVE.getValue()));
                break;
            case "Company":
                response.setResponseObject(DBM.getRecordsBy(Company.class, "Status", Status.ACTIVE.getValue()));
                break;
            case "Route":
                response.setResponseObject(DBM.getRecordsBy(Route.class, "Status", Status.ACTIVE.getValue()));
                break;
            case "Shop":
                response.setResponseObject(DBM.getRecordsBy(Shop.class, "Status", Status.ACTIVE.getValue()));
                break;
            default:
                response.setError(true);
                response.setErrorMsg("Invalid Param");
        }
        return response;
    }

    @Override
    public Object getObjectById(long id, Class c) {
        return DBM.getSingleRecordById(c, 1);
    }

    @Override
    public Response insertRecord(Object object, String className) {
        Response response;
        switch (className) {
            case "AppUser":
                response = insertUtils.insertUsers((AppUser) object);
                break;
            case "Products":
                response = insertUtils.insertProducts((Products) object);
                break;
            case "Route":
                response = insertUtils.insertRoute((Route) object);
                break;
            case "Booker":
                response = insertUtils.insertBookers((Booker) object);
                break;
            case "Shop":
                response = insertUtils.insertShop((Shop) object);
                break;
            case "Stock":
                response = insertUtils.insertStock((Stock) object);
                break;
            case "WorkingSchedule":
                response = insertUtils.insertWorkingSch((WorkingSchedule) object);
                break;
            case "Invoice":
                response = insertUtils.insertInvoice((Invoice) object);
                break;
            case "BookerCr":
                response = insertUtils.insertBookerCr((BookerCr) object);
                break;
            default:
                return new Response("invalid Input");
        }
        return response;
    }

    @Override
    public Response updateRecord(Object object, String className) {

        Response response = new Response("invalid Input");
        switch (className) {

            case "Products":
                response = updateUtils.updateProducts((Products) object);
                break;
            case "Shop":
                response = updateUtils.updateShop((Shop) object);
                break;
            case "WorkingSchedule":
                response = updateUtils.updateWorkingSchedule((WorkingSchedule) object);
                break;
            case "Summary":
                response = updateUtils.updateSummary((Summary) object);
                break;
            case "Booker":
                response = updateUtils.updateBooker((Booker) object);
                break;

        }
        return response;
//        AppUser user = (AppUser) object;
//        if (dbmUtils.isUserExist(user.getUserName(), user.getUserId(), true)) {
//            return new Response("User Name Already Exists");
//        } else {
//            return new Response(DBM.updateRecords(Users.class, user));
//        }
    }

    @Override
    public Response deleteRecord(long objectId, Class c) {
        return new Response(DBM.deleteRecords(c, objectId), "");
    }

    @Override
    public Response login(Login login) {
        if (dbmUtils.isUserExist(login.getUserName(), 0, false)) {
            if (dbmUtils.islogedIn(login)) {
                Global.LOGGED_USER = (AppUser) DBM.getRecordsBy(AppUser.class, "UserName", login.getUserName()).get(0);
                Global.LOGGED_USER.setLoggedIn(true);
                return new Response(true, "Login Successful");
            } else {
                return new Response("Incorrect Password");
            }
        } else {
            return new Response("Incorrect User Name");
        }
    }

    @Override
    public Response logout() {
        if (Global.LOGGED_USER.isLoggedIn()) {
            Global.LOGGED_USER = new AppUser();
            return new Response(true, "Successfully Logged out");
        } else {
            return new Response("You are already Logged out");
        }
    }

    @Override
    public Response BackUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response Restore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Response insertTransction(Object object, Double amount, int transactionType) {
        Response response;
        switch (transactionType) {
            case 3: // booker cr
                Transactions tr = new Transactions(((Booker) object).getId(), transactionType, amount);
                response = insertUtils.insertTransactions(tr);
                break;
            default:
                return new Response("invalid Input");
        }
        return response;
    }

}
