package com.example.api.demo.services.mobile;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.api.demo.responses.PlayerResponse;
import com.example.api.demo.responses.mobileResponses.PlayerProfileResponse;

public interface IPlayerProfileResponseService {
    
    public ResponseEntity <PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse, String firstName, String lastName);
}
