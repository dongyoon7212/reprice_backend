package com.example.reprice_backend.dto;

public class ApiRespDto<T> {
    private String status;
    private String message;
    private T data;
}
