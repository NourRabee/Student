package com.example.school.app.school.common.dto;

public abstract class BaseRequest<T>{

    public abstract void setId(T t);
    public abstract T getId();
}
