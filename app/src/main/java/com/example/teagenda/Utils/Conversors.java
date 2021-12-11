package com.example.teagenda.Utils;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversors {
    @TypeConverter
    public String toString(Date date) {
        DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
        return dF.format(date);
    }

    @TypeConverter
    public Date toDate(String string) {
        DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
        Date d;
        try { d = dF.parse(string); }
        catch (Exception e) { d = new Date(); }
        return d;
    }
}
