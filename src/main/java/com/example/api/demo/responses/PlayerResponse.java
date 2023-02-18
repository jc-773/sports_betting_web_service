package com.example.api.demo.responses;

import java.util.List;

import com.example.api.demo.responses.containers.PlayerResponseContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerResponse {
    
    @JsonProperty("key")
    public List<PlayerResponseContainer> response;

}
