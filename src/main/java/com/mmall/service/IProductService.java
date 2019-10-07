package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.commom.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);
    //修改产品上下架状态Service接口
    ServerResponse<String> setSaleStatus(Integer productId,Integer status);
    //获取商品详情
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
    //获取产品List
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);
    //产品搜索
    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);
    //前台商品详情
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);
    //前台商品详情搜索，列表，动态排序
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy);
}
