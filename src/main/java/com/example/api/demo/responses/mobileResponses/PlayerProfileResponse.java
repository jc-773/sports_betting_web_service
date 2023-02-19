package com.example.api.demo.responses.mobileResponses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProfileResponse {
    
    @JsonProperty("response")
    public List<PlayerProfileResponseType> playerProfileResponseType;
    
}
