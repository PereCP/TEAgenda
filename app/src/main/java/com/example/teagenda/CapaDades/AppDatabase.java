package com.example.teagenda.CapaDades;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.teagenda.CapaDomini.Evento;
import com.example.teagenda.Utils.Conversors;

@Database(entities = {Evento.class}, version = 1)
@TypeConverters({Conversors.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract EventoDao eventoDao();
}