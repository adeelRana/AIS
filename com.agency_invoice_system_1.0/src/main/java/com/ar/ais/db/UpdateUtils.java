/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.db;

import com.ar.ais.models.EntityBeans.AppUser;
import com.ar.ais.models.EntityBeans.Booker;
import com.ar.ais.models.EntityBeans.Products;
import com.ar.ais.models.EntityBeans.Shop;
import com.ar.ais.models.EntityBeans.Summary;
import com.ar.ais.models.EntityBeans.WorkingSchedule;
import com.ar.ais.models.Response;

/**
 *
 * @author Adeel rana
 */
public class UpdateUtils extends DbmUtils {

    private Response updateUsers(AppUser user) {
        if (super.isUserExist(user.getUserName(), 0, false)) {
            return new Response("User Already Exists");
        } else {
            return new Response(DBM.insertRecords(AppUser.class, user));
        }
    }

    public Response updateProducts(Products product) {
        return new Response(DBM.updateRecords(Products.class, (product)));
    }

    public Response updateWorkingSchedule(WorkingSchedule ws) {
        return new Response(DBM.updateRecords(WorkingSchedule.class, ws));
    }

    public Response updateSummary(Summary summary) {
        return new Response(DBM.updateRecords(Summary.class, summary));
    }

    public Response updateBooker(Booker booker) {
        return new Response(DBM.updateRecords(Booker.class, booker));
    }

    public Response updateShop(Shop shop) {
        return new Response(DBM.updateRecords(Shop.class, shop));
    }
}
