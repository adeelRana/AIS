/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models;

/**
 *
 * @author Adeel rana
 */
public class Response {

    private boolean success;
    private boolean error;
    private String errorMsg;
    private String responseMsg;
    private Object responseObject;

    public Response() {
    }

    public Response(String errorMsg) {
        this.error = true;
        this.errorMsg = errorMsg;
    }

    public Response(boolean success, String responseMsg) {
        this.success = success;
        this.error = false;
        this.responseMsg = responseMsg;
    }

    public Response(Object responseObject) {
        if (null != responseObject) {
            this.success = true;
            this.error = false;
            this.responseObject = responseObject;
            this.responseMsg = "";
        } else {
            this.success = false;
            this.error = true;
            this.responseObject = null;
            this.responseMsg = "Err-DB";
        }

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

}
