package com.example.teagenda.CapaDomini;

import android.graphics.Color;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Random;

@Entity
public class Evento {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    //@ColumnInfo(name = "color")
    //private Color color;

    public Evento() {
        Random rand = new Random();
        this.id = rand.nextInt();

        this.title = "";
        this.description = "";
        //this.color = new Color();
    }

    public Evento(String title, String description, Color color) {
        Random rand = new Random();
        this.id = rand.nextInt();

        this.title = title;
        this.description = description;
        //this.color = color;
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

    /*public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
     */
}
