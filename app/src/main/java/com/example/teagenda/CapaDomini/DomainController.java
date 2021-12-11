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

    private DomainController(Context ctx) {
        context = ctx.getApplicationContext();
        eventoManager = new EventoManager();
        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "base-dades").allowMainThreadQueries().build();
        selectedEvento = null;

        for (Evento e : appDatabase.eventoDao().getAll()) {
            eventoManager.addEvento(e);
        }
    }

    public static void buildDomainController(Context ctx) {
        if (instance == null)
            instance = new DomainController(ctx);
    }

    public static DomainController getInstance() {
        return instance;
    }

    public List<Evento> getEventos() {
        return eventoManager.getEventos();
    }

    public Evento getEvento(int id) {
        return eventoManager.getEvento(id);
    }

    public void addEvento(Evento e) {
        this.eventoManager.addEvento(e);
    }

    public static void closeDomainController() {
        if (instance != null) {
            instance.appDatabase.eventoDao().removeAll();
            for (Evento e : instance.eventoManager.getEventos()) {
                instance.appDatabase.eventoDao().insertAll(e);
            }
            instance.appDatabase.close();
        }
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
