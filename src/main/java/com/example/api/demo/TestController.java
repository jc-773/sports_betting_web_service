package com.example.api.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.responses.PlayerResponse;
import com.example.api.demo.services.IBackendRequestService;

@RestController
public class TestController {
    private final IBackendRequestService backendRequests;

    @Autowired
    public TestController(IBackendRequestService backendRequests) {
        this.backendRequests = backendRequests;
    }

    @RequestMapping(value="/nba/players", method=RequestMethod.GET)
    public ResponseEntity<PlayerResponse> getNBATest(@RequestHeader(value = "name") String name, @RequestHeader(value = "Ocp-Apim-Subscription-Key") String sdToken) {
        List<PlayerResponse> playerResponse =  backendRequests.PlayerInformation_Get(sdToken);

        //TODO: make call asynchronous and store response in db. All subsequent calls will have latest stored data on players
        return null;
    }
}
