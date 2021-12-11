package com.example.teagenda.CapaDomini;

import java.util.HashMap;

public class EventoManager {
    private HashMap<Integer, Evento> eventos = new HashMap<>();

    public EventoManager() {
        this.eventos = new HashMap<>();
    }

    public EventoManager(HashMap<Integer, Evento> eventos) {
        this.eventos = eventos;
    }

    public Evento getEvento(int id) {
        return this.eventos.get(id);
    }

    public void addEvento(Evento evento) {
        this.eventos.put(evento.getId(), evento);
    }

    public HashMap<Integer, Evento> getEventos() {
        return eventos;
    }

    public void setEventos(HashMap<Integer, Evento> eventos) {
        this.eventos = eventos;
    }
}
