package com.example.api.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.responses.PlayerResponse;
import com.example.api.demo.responses.mobileResponses.PlayerProfileResponse;
import com.example.api.demo.services.IBackendRequestService;
import com.example.api.demo.services.mobile.IPlayerProfileResponseService;

@RestController
public class TestController {
    private final IBackendRequestService backendRequests;
    private final IPlayerProfileResponseService playerResponseService;

    @Autowired
    public TestController(IBackendRequestService backendRequests, IPlayerProfileResponseService playerResponseService) {
        this.backendRequests = backendRequests;
        this.playerResponseService = playerResponseService;
    }

    @RequestMapping(value="/nba/players", method=RequestMethod.GET)
    public ResponseEntity<PlayerProfileResponse> getNBAPlayer (@RequestHeader(value = "firstName") String firstName, @RequestHeader(value = "lastName") String lastName, @RequestHeader(value = "Ocp-Apim-Subscription-Key") String sdToken) {
        List<PlayerResponse> playerResponse =  backendRequests.PlayerInformation_Get(sdToken);
       
        //TODO: make call asynchronous and store response in db. All subsequent calls will have latest stored data on players
        
        return playerResponseService.returnPlayerProfile(playerResponse, firstName, lastName);
    }
}
