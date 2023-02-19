package com.example.api.demo.services.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.demo.responses.PlayerResponse;
import com.example.api.demo.responses.mobileResponses.PlayerProfileResponse;
import com.example.api.demo.responses.mobileResponses.PlayerProfileResponseType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlayerProfileResponseService implements IPlayerProfileResponseService {

    @Override
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse, String firstName, String lastName) {
       
        PlayerResponse readValue = mapObject(playerResponse);
        PlayerProfileResponse mobilePlayerProfileResponse = instantiatePlayerProfileResponseObj();
        mobilePlayerProfileResponse.playerProfileResponseType.get(0).firstName = firstName;
        mobilePlayerProfileResponse.playerProfileResponseType.get(0).lastName = lastName;

        for (int i = 0; i < readValue.response.size(); i++) {
            if (readValue.response.get(i).firstName.equalsIgnoreCase(firstName)
                    && readValue.response.get(i).lastName.equalsIgnoreCase(lastName)) {
                        mobilePlayerProfileResponse.playerProfileResponseType.get(0).playerID = readValue.response.get(i).playerID;
                        mobilePlayerProfileResponse.playerProfileResponseType.get(0).status = readValue.response.get(i).status;
                        mobilePlayerProfileResponse.playerProfileResponseType.get(0).team = readValue.response.get(i).team;
                        mobilePlayerProfileResponse.playerProfileResponseType.get(0).position = readValue.response.get(i).position;
            }
        }

        return new ResponseEntity<PlayerProfileResponse>(mobilePlayerProfileResponse, HttpStatus.OK);
    }

    private static PlayerProfileResponse instantiatePlayerProfileResponseObj () {
     
        PlayerProfileResponse mobProfileResponse = new PlayerProfileResponse();
         mobProfileResponse.playerProfileResponseType = new ArrayList<>();
         mobProfileResponse.playerProfileResponseType.add(new PlayerProfileResponseType());

        return mobProfileResponse;
       
    }

    private static PlayerResponse mapObject(List<PlayerResponse> playerResponse) {
        PlayerResponse readValue;
        try {
            Map<String, List<PlayerResponse>> playerProfMap = new HashMap<>();
            playerProfMap.put("key", playerResponse);
            String jsonString = new ObjectMapper().writeValueAsString(playerProfMap);
            ObjectMapper mapper = new ObjectMapper();
            readValue = mapper.readValue(jsonString, PlayerResponse.class);
            return readValue;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

}
