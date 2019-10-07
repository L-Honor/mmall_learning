package com.mmall.dao;

import com.mmall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    //根据用户id和主键shippingId删除收货地址，防止横向越权
    int deleteByShippingIdUserId(@Param("userId") Integer userId,@Param("shippingId") Integer shippingId);
    //根据用户id和主键shippingId更新收货地址，防止横向越权
    int updateByShipping(Shipping record);
    //根据用户id和主键shippingId查询收货地址详情，防止横向越权
    Shipping selectByShippingIdUserId(@Param("userId") Integer userId,@Param("shippingId") Integer shippingId);
    //根据用户id查询出用户所有收货地址信息
    List<Shipping> selectByUserId(@Param("userId") Integer userId);

}