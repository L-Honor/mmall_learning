package com.mmall.controller.portal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mmall.commom.Const;
import com.mmall.commom.ResponseCode;
import com.mmall.commom.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.req.ExcelReq;
import com.mmall.service.res.BaseRes;
import com.mmall.service.res.ExcelRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order/")
public class OrderController {

    @Value("")
    private String url;

    public ServerResponse pay(HttpSession session, Long orderNo, HttpServletRequest request){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN
                    .getDesc());
        }
        String path = request.getSession().getServletContext().getRealPath("upload");

        RestTemplate restTemplate = new RestTemplate();

        ExcelReq excelReq = new ExcelReq();
        excelReq.setA("1");
        excelReq.setB("1");
        excelReq.setC("1");


        ResponseEntity<BaseRes> baseResResponseEntity = restTemplate.postForEntity(url, excelReq, BaseRes.class);
        String resCode = baseResResponseEntity.getBody().getResCode();
        if ("00000".equals(resCode)){
            if (baseResResponseEntity.getBody().getData() != null){
                Object data = baseResResponseEntity.getBody().getData();
                ExcelRes excelRes = JSONObject.parseObject(JSON.toJSONString(data), ExcelRes.class);
                String d = excelRes.getD();
                String de = excelRes.getE();
                String df = excelRes.getF();
            }
        }
        if ("0001".equals(resCode)){
            new ServerResponse(1);
        }


        return new ServerResponse(1);
    }

}
