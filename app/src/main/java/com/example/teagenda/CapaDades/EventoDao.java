package com.example.teagenda.CapaDades;

import androidx.room.*;

import com.example.teagenda.CapaDomini.Evento;

import java.util.List;

@Dao
public interface EventoDao {
    @Query("SELECT * FROM evento")
    List<Evento> getAll();

    @Query("SELECT * FROM evento WHERE id = (:eventoId)")
    Evento getByID(int eventoId);

    @Query("SELECT * FROM evento WHERE id IN (:eventoIds)")
    List<Evento> loadAllByIds(int[] eventoIds);

    @Insert
    void insertAll(Evento... eventos);

    @Insert
    void insertMultiple(List<Evento> list);

    @Query("DELETE FROM evento")
    void removeAll();
}
