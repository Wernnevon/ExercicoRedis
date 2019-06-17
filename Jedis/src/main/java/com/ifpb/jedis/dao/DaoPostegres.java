package com.ifpb.jedis.dao;
import com.ifpb.jedis.model.Postagem;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DaoPostegres {


    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://Localhost:5432/ExercicoRedis", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void escrevendo (Postagem post) throws SQLException {
        String sql = "insert into postagem (datapost, ID ,horapost, corpo, IdUser) values('"+ post.getData() + "','" + post.getID() + "','" + post.getHora() + "','"+post.getCorpo() + "','" + post.getIdUser() + "')";
        Connection conexao = new DaoPostegres().getConnection();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();

        System.out.println("Gravado!");

        conexao.close();
    }
    public Postagem buscando (int id) throws SQLException, ParseException {
        Postagem post = new Postagem(null, 0, null, "",0);
        String sql = "select * from postagem where id="+id;
        Connection conexao = new DaoPostegres().getConnection();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String date = rs.getString("datapost");
            post.setData(date);
            post.setCorpo(rs.getString("corpo"));
            post.setHora(java.sql.Time.valueOf(rs.getString("horapost")));
            post.setID(rs.getInt("ID"));
            post.setIdUser(rs.getInt("IdUser"));
        }
        stmt.close();
        conexao.close();
        return post;
    }
}
