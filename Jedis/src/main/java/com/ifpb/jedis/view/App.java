package com.ifpb.jedis.view;

import com.ifpb.jedis.control.Gerenciador;
import com.ifpb.jedis.dao.DaoPostegres;
import com.ifpb.jedis.model.Postagem;

import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) throws SQLException, ParseException {
        Gerenciador manager = new Gerenciador();
        manager.buscarPost(3);
    }
}
