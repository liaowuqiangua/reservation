package com.ycj.reservation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycj.reservation.mapper.GoodsMapper;
import com.ycj.reservation.pojo.Goods;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Service
public class GoodsService {
    private Logger log = LogManager.getLogger(GoodsService.class);
    private final Map<String, String> params = Collections.emptyMap();
    @Autowired
    private RestClient restClient;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    private static final String ERROR_STATUS ="{\"status\":\"404\"}";

    @Transactional
    public String insertGoods(Goods goods){
        String id = UUID.randomUUID().toString();
        try {
            goodsMapper.insertGoods(goods.getGoodsID(),goods.getVolume());
            HttpEntity entity = new NStringEntity(objectMapper.writeValueAsString(goods), ContentType.APPLICATION_JSON);
            Response response = restClient.performRequest("put","/reservation/goods/"+id,params,entity);
            return "{\"status\":\""+response.getStatusLine().getStatusCode()+"\"}";
        }
        catch (Exception e){
            log.error(e.getMessage()+"id :"+id+"insert failure !");
            e.printStackTrace();
        }
        return ERROR_STATUS;
    }
    @Transactional
    public String deleteGoodsByID(String goodsID){
        try {
            goodsMapper.deleteGoods(goodsID);
            Response response = restClient.performRequest("DELETE","reservation/goods/"+goodsID);
            return "{\"status\":\""+response.getStatusLine().getStatusCode()+"\"}";
        }
        catch (Exception e){
            log.error(e.getMessage()+"id :"+goodsID+"delete failure !");
            e.printStackTrace();
        }
        return ERROR_STATUS;
    }
    /*
    * @param goodsID 传入商品ID
    * @param delta 商品数量修改量
    * @param goods 修改后的商品
    * */
    @Transactional
    public String updateGoods(String goodsID,int delta,Goods goods){
        try {
            if(delta != 0){
                goodsMapper.updateGoods(goodsID,delta);
            }
            HttpEntity entity = new NStringEntity(objectMapper.writeValueAsString(goods), ContentType.APPLICATION_JSON);
            Response response = restClient.performRequest("PUT","/reservation/goods/"+goodsID,params,entity);
            return "{\"status\":\""+response.getStatusLine().getStatusCode()+"\"}";
        }
        catch (Exception e){
            log.error(e.getMessage()+"id :"+goodsID+"update failure !");
            e.printStackTrace();
        }
        return ERROR_STATUS;
    }
    /*
    * @param jsonObject DSL语句
    * @param size 分页大小
    * @param from 第几页
    * */
    public String searchGoods(String jsonObject,int size , int from){
        try{
            HttpEntity entity = new NStringEntity(jsonObject, ContentType.APPLICATION_JSON);
            Response response = restClient.performRequest("GET","/reservation/goods/_search?size="+size+"&from="+from,params,entity);
            return EntityUtils.toString(response.getEntity());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return ERROR_STATUS;
    }
}
