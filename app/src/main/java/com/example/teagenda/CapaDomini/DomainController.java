package com.example.teagenda.CapaDomini;

import android.content.Context;

import androidx.room.Room;

import com.example.teagenda.CapaDades.AppDatabase;
import com.example.teagenda.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class DomainController {
    private static DomainController instance;
    private EventoManager eventoManager;
    private AppDatabase appDatabase;
    private Context context;

    private DomainController(Context ctx) {
        context = ctx.getApplicationContext();
        eventoManager = new EventoManager();
        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "base-dades").build();
    }

    public static void buildDomainController(Context ctx) {
        if (instance == null)
            instance = new DomainController(ctx);
    }

    public static DomainController getInstance() {
        return instance;
    }

    public List<Evento> getEventos() {
        return new ArrayList<>(eventoManager.getEventos().values());
    }

    public Evento getEvento(int id) {
        return eventoManager.getEvento(id);
    }

    public void addEvento(Evento e) {
        this.eventoManager.addEvento(e);
    }

    public static void closeDomainController() {
        if (instance != null) {
            for (Evento e : instance.eventoManager.getEventos().values()) {
                instance.appDatabase.eventoDao().insertAll(e);
            }
            instance.appDatabase.close();
        }
    }
}
