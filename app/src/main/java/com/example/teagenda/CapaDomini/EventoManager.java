package com.example.teagenda.CapaDomini;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventoManager {
    private ArrayList<Evento> eventos;

    public EventoManager() {
        this.eventos = new ArrayList<>();
    }

    public EventoManager(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public Evento getEvento(int id) {
        return this.eventos.get(id);
    }

    public void addEvento(Evento evento) {
        evento.setId(this.eventos.size());
        this.eventos.add(evento);
    }

    public ArrayList<Evento> getEventos() {
        ArrayList<Evento> retVal = new ArrayList<>();
        for (Evento e : this.eventos)
            if (e != null) retVal.add(e);
        return retVal;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<String> getTitulosEventos() {
        ArrayList<String> retval = new ArrayList<>();
        for (Evento e : this.eventos)
            if (e != null)
                retval.add(e.getTitle());
        return retval;
    }

    public void removeEvento(int id) {
        this.eventos.set(id, null);
    }
}
