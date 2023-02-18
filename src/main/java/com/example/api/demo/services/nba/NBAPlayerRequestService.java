package com.example.api.demo.services.nba;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.demo.responses.PlayerResponse;
import com.example.api.demo.services.IRestTemplateService;

@Service
public class NBAPlayerRequestService implements INBAPlayerRequestService {

    @Autowired
    private IRestTemplateService restTemplateService;

    @Autowired
    public NBAPlayerRequestService(IRestTemplateService restTemplateService) {
       this.restTemplateService = restTemplateService;
    }
    
    @Override
    public <T> T PlayerResponse_Get(Class<T> clazz, String token) {
        String url = "https://api.sportsdata.io/v3/nba/scores/json/Players";
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Ocp-Apim-Subscription-Key", token);
        //PlayerResponse[] response = requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
        return (T) restTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
    }
    
}
