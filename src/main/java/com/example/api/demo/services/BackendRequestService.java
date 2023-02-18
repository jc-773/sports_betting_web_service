package com.example.api.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.demo.responses.PlayerResponse;
import com.example.api.demo.services.nba.INBAPlayerRequestService;

@Service
public class BackendRequestService implements IBackendRequestService {

    private final INBAPlayerRequestService nbaPlayerRequests;
    
    @Autowired
    public BackendRequestService(INBAPlayerRequestService nbaPlayerRequests) {
        this.nbaPlayerRequests = nbaPlayerRequests;
    }

    @Override
    public List<PlayerResponse> PlayerInformation_Get(String key) {
        return (List<PlayerResponse>) nbaPlayerRequests.PlayerResponse_Get(PlayerResponse.class, key);
    }
    
}
