package com.example.api.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.api.demo.responses.PlayerResponse;

@Service
public interface IBackendRequestService {
    public List<PlayerResponse> PlayerInformation_Get(@RequestHeader String key);
}
