/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.db;

import com.ar.ais.models.EntityBeans.AppUser;
import com.ar.ais.models.EntityBeans.Booker;
import com.ar.ais.models.EntityBeans.BookerCr;
import com.ar.ais.models.EntityBeans.Company;
import com.ar.ais.models.EntityBeans.Invoice;
import com.ar.ais.models.EntityBeans.Products;
import com.ar.ais.models.EntityBeans.Route;
import com.ar.ais.models.EntityBeans.Shop;
import com.ar.ais.models.EntityBeans.Stock;
import com.ar.ais.models.EntityBeans.Transactions;
import com.ar.ais.models.EntityBeans.WorkingSchedule;
import com.ar.ais.models.Response;

/**
 *
 * @author Adeel rana
 */
public class InsertUtils extends DbmUtils {

    public Response insertUsers(AppUser user) {
        if (super.isUserExist(user.getUserName(), 0, false)) {
            return new Response("User Already Exists");
        } else {
            return new Response(DBM.insertRecords(AppUser.class, user));
        }
    }

    public Response insertProducts(Products product) {
//        if (dbmUtils.isProductExist(product)) {
//            return new Response("Product Already Exists");
//        } else {
        return new Response(DBM.insertRecords(Products.class, product));
//        }
    }

    public Response insertCompany(Company company) {
        return new Response(DBM.insertRecords(Company.class, company));
    }

    public Response insertRoute(Route route) {
        return new Response(DBM.insertRecords(Route.class, route));
    }

    public Response insertBookers(Booker booker) {
        return new Response(DBM.insertRecords(Booker.class, booker));
    }

    public Response insertShop(Shop shop) {
        return new Response(DBM.insertRecords(Shop.class, shop));
    }

    public Response insertStock(Stock stock) {
        return new Response(DBM.insertRecords(Stock.class, stock));
    }

    public Response insertWorkingSch(WorkingSchedule ws) {
        if (super.isWorkingScheduleExist(ws)) {
            return new Response("Working Schedule Already Exists");
        } else {
            return new Response(DBM.insertRecords(WorkingSchedule.class, ws));
        }
    }

    public Response insertInvoice(Invoice i) {
        return new Response(DBM.insertRecords(Invoice.class, i));
    }

    public Response insertTransactions(Transactions t) {
        return new Response(DBM.insertRecords(Transactions.class, t));
    }

    public Response insertBookerCr(BookerCr t) {
        return new Response(DBM.insertRecords(Transactions.class, t));
    }
}
