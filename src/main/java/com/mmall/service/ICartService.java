package com.mmall.service;

import com.mmall.commom.ServerResponse;
import com.mmall.vo.CartVo;

public interface ICartService {

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
    //更新购物车商品数量
    ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count);
    //在购物车中删除指定的商品
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);
    //查询购物车中商品
    ServerResponse<CartVo> list(Integer userId);
    //购物车中商品钩选
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);
    //查询当前用户的购物车里面的产品数量
    ServerResponse<Integer> getCartProductCount(Integer userId);

}
