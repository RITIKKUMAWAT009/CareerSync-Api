package com.example.careersyncapp;

public class ApiResponse {
    String message;
    boolean success;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

}
