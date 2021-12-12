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
    private Evento selectedEvento;
    private AppDatabase appDatabase;
    private Context context;
    private boolean active;

    private DomainController(Context ctx) {
        context = ctx.getApplicationContext();
        eventoManager = new EventoManager();
        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "base-dades").allowMainThreadQueries().build();
        selectedEvento = null;
        active = false;

        for (Evento e : appDatabase.eventoDao().getAll()) {
            eventoManager.addEvento(e);
        }
    }

    public static void buildDomainController(Context ctx) {
        if (instance == null) {
            instance = new DomainController(ctx);
            instance.active = true;
        }
    }

    public static void restoreDomainController(Context ctx) {
        instance.context = ctx;
        instance.eventoManager = new EventoManager();
        instance.appDatabase = Room.databaseBuilder(instance.context,
                AppDatabase.class, "base-dades").allowMainThreadQueries().build();
        instance.active = true;

        for (Evento e : instance.appDatabase.eventoDao().getAll()) {
            instance.eventoManager.addEvento(e);
        }
    }

    public static void saveDomainController() {
        if (instance != null && instance.active) {
            instance.appDatabase.eventoDao().removeAll();
            for (Evento e : instance.eventoManager.getEventos()) {
                instance.appDatabase.eventoDao().insertAll(e);
            }
            instance.appDatabase.close();
            instance.active = false;
        }
    }

    public static DomainController getInstance() {
        return instance;
    }

    public List<Evento> getEventos() {
        if (this.active)
            return eventoManager.getEventos();
        else
            return null;
    }

    public Evento getEvento(int id) {
        if (this.active)
            return eventoManager.getEvento(id);
        else
            return null;
    }

    public void addEvento(Evento e) {
        if (this.active)
            this.eventoManager.addEvento(e);
    }

    public Evento getSelectedEvento() {
        return selectedEvento;
    }

    public void setSelectedEvento(int id) {
        this.selectedEvento = this.eventoManager.getEvento(id);
    }

    public List<String> getTitulosEventos() {
        return this.eventoManager.getTitulosEventos();
    }
}
