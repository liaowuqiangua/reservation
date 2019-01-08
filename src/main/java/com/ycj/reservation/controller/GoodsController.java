package com.ycj.reservation.controller;

import com.ycj.reservation.pojo.Goods;
import com.ycj.reservation.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @PostMapping("/insert")
    public String insertGoods(@RequestBody Goods goods) throws IOException {
        return goodsService.insertGoods(goods);
    }

    @PostMapping("/delete")
    public String deleteGoods(@RequestParam String goodsID){
        return goodsService.deleteGoodsByID(goodsID);
    }

    @PostMapping("/update")
    public String updateGoods(@RequestParam String goodsID,@RequestParam int delta ,@RequestParam Goods goods){
        return goodsService.updateGoods(goodsID,delta,goods);
    }
    @PostMapping("/select")
    public String selectGoods(@RequestParam String jsonObject,@RequestParam int size,@RequestParam int from){
        return goodsService.searchGoods(jsonObject,size,from);
    }
}
