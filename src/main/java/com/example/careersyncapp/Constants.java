package com.example.careersyncapp;

import com.example.careersyncapp.model.UserT;
import jakarta.websocket.OnClose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static final String RECORDS_FOUND = "Records Found";
    public static final String DATA = "Data";

    public static Map<String,Object>createMap(List<Object> data){
        Map<String,Object>response=new HashMap<>();
        response.put(Constants.RECORDS_FOUND,data.size());
        response.put(Constants.DATA,data);
        return response;
    }
    public static Map<String,Object>createMap(Object data){
        Map<String,Object>response=new HashMap<>();
        response.put(Constants.DATA,data);
        return response;
    }
}
