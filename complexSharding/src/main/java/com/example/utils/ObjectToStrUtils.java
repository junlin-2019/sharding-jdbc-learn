package com.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/30 16:09
 */
public class ObjectToStrUtils {

    public static  String JSONString(Object obj){
        ObjectMapper om = new ObjectMapper();
        String result = null;
        try {
            result = om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
