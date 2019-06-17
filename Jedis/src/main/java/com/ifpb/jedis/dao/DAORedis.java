package com.ifpb.jedis.dao;

import com.google.gson.Gson;
import com.ifpb.jedis.model.CacheResult;
import com.ifpb.jedis.model.Postagem;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class DAORedis {

    private Jedis jedis;
    private Gson gson;

    public DAORedis(){
        jedis = new Jedis();
        gson = new Gson();
    }
    public boolean salvar(Postagem post){
        return jedis.set(""+post.getID(),gson.toJson(post),
                SetParams.setParams().ex(3600)) != null;
    }

    public CacheResult buscar(int id){
        return jedis.get(""+id) == null? CacheResult.CACHE_MISS :
                CacheResult.CACHE_HIT;
    }

    public Postagem get(int id){
        String json = jedis.get(""+id);
        if(json == null) return null;
        return gson.fromJson(json, Postagem.class);
    }
}
