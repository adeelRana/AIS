/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.utililty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Adi Rana
 */
public class DateUtility {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
    private static final SimpleDateFormat DATE_FORMAT_NUMBERS = new SimpleDateFormat("ddMMyyyy");
    private static final SimpleDateFormat DATE_FORMAT_DAY = new SimpleDateFormat("EEEEEE");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm");

    public Date getNewDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public long getDBTimeFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
//        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime().getTime();

    }

    public String getStingTimeFromDate(Date date) {
        return null == date ? TIME_FORMAT.format(new Date()) : TIME_FORMAT.format(date);
    }

    public String getStingDateFromLongValue(long date) {
        return DATE_FORMAT.format(new Date(date));
    }

    public String getDayOfWeek(long date) {
        return DATE_FORMAT_DAY.format(new Date(date));
    }

    public Date getDateFromString(String val) {
        try {
            return DATE_FORMAT_NUMBERS.parse(val);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Date");
            return null;
        }
    }
}
