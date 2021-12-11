package com.example.teagenda.CapaDades;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.teagenda.CapaDomini.Evento;

@Database(entities = {Evento.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EventoDao eventoDao();
}