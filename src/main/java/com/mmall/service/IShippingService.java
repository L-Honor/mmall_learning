package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.commom.ServerResponse;
import com.mmall.pojo.Shipping;

public interface IShippingService {

    //添加收货地址
    ServerResponse add(Integer userId, Shipping shipping);

    //删除收货地址--据用户id和主键shippingId删除收货地址，防止横向越权
    ServerResponse<String> del(Integer userId, Integer shippingId);
    //更新收货地址--据用户id和主键shippingId更新收货地址，防止横向越权
    ServerResponse update(Integer userId, Shipping shipping);
    //查询收货地址详情 --根据用户id和主键shippingId查询收货地址详情，防止横向越权
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    //分页查询收货地址列表
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
