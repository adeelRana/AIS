/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.controller;

import com.ar.ais.models.Response;
import com.ar.ais.models.Login;

/**
 *
 * @author Adeel rana
 */
public interface ControllerInterface {

    public Response fetch(String param);

    public Response fetchActive(String param);

    public Object getObjectById(long id, Class c);

    public Response login(Login login);

    public Response logout();

    public Response insertRecord(Object object, String className);

    public Response updateRecord(Object object, String className);

    public Response deleteRecord(long id, Class className);

    public Response BackUp();

    public Response Restore();

}
