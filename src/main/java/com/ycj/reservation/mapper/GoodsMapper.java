package com.ycj.reservation.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GoodsMapper {
    @Insert("insert into goods(goodsID,volume) values(#{goodsID}, #{volume})")
    public int insertGoods(@Param("goodsID") String goodsID,@Param("volume") int volume);

    @Delete("delete from goods where goodsID = {#goodsID}")
    public int deleteGoods(@Param("goodsID")String goodsID);

    @Update("update goods set volume = volume+{#delta} where goodsID = {#goodsID}")
    public int updateGoods(@Param("goodsID")String goodsID,@Param("delta")int delta);
}
