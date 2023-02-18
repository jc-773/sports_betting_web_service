package com.example.api.demo.services.nba;

public interface INBAPlayerRequestService {
    public <T> T PlayerResponse_Get(Class<T> clazz, String token);
}
