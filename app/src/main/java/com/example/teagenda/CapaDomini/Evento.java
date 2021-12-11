package com.example.teagenda.CapaDomini;

import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Random;

@Entity
public class Evento {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColorInt
    @ColumnInfo(name = "color")
    private int color;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "isCompleted")
    private boolean isCompleted;

    public Evento() {
        Random rand = new Random();
        this.id = rand.nextInt();

        this.title = "";
        this.description = "";
        this.color = Color.WHITE;
        this.date = new Date();
    }

    public Evento(String title, String description, int color, Date date, boolean isCompleted) {
        Random rand = new Random();
        this.id = rand.nextInt();

        this.title = title;
        this.description = description;
        this.color = color;
        this.date = date;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
