package com.ifpb.jedis.control;

import com.ifpb.jedis.dao.DAORedis;
import com.ifpb.jedis.dao.DaoPostegres;
import com.ifpb.jedis.model.CacheResult;
import com.ifpb.jedis.model.Postagem;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.text.ParseException;

public class Gerenciador {

    public void buscarPost (int id) throws SQLException, ParseException {
        DAORedis jedis = new DAORedis();
        Postagem post;
        if(jedis.buscar(id)== CacheResult.CACHE_HIT){
            post = jedis.get(id);
            System.out.println(post.getCorpo() + "\n" + CacheResult.CACHE_HIT);
        }else {
            DaoPostegres daoPostegres = new DaoPostegres();
            post = daoPostegres.buscando(id);
            jedis.salvar(post);
            System.out.println(post.getCorpo());

        }

    }
}
