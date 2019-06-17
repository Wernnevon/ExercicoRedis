package com.ifpb.jedis.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Postagem {
    private LocalDate data;
    private int ID;
    private Time hora;
    private String corpo;
    private int IdUser;

    public Postagem(LocalDate data, int ID, Time hora, String corpo, int idUser) {
        this.data = data;
        this.ID = ID;
        this.hora = hora;
        this.corpo = corpo;
        IdUser = idUser;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(String data) {
        LocalDate date = LocalDate.parse(data);
        this.data = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    @Override
    public String toString() {
        return "Postagem{" +
                "data=" + data +
                ", ID=" + ID +
                ", hora=" + hora +
                ", corpo='" + corpo + '\'' +
                ", IdUser=" + IdUser +
                '}';
    }
}
