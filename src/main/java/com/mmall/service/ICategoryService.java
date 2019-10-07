package com.mmall.service;

import com.mmall.commom.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    //添加品类
    ServerResponse addCategory(String categoryName, Integer parentId);
    //更新品名
    ServerResponse updateCategoryName(Integer categoryId,String categoryName);
    //根据parentId获取子节点的category信息
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    //查询本节点的id及孩子节点的id
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
