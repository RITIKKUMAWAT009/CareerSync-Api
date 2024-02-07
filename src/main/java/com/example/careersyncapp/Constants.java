package com.example.careersyncapp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static final String RECORDS_FOUND = "Records Found";
    public static final String DATA = "Data";
    public static final String SUCCESS = "Login successfully";
    public static final String FAILURE = "Invalid username or password";
    public static final String ALREADY_TAKEN = "Username is already taken";
    public static final String CREATED_SUCCESS = "User created successfully";

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
