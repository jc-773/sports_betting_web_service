package com.example.api.demo.services;

import java.util.Hashtable;

public interface IRestTemplateService {
    public <T, R> T getForObjectResponse(Class<T> clazz, String url, Hashtable<String, String> customHeaders);
}
