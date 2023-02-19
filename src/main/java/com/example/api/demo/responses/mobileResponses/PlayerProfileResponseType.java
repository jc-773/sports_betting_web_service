package com.example.api.demo.responses.mobileResponses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProfileResponseType {
    @JsonProperty("playerID")
    public String playerID;

    @JsonProperty("status")
    public String status;

    @JsonProperty("team")
    public String team;

    @JsonProperty("position")
    public String position;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    // @JsonProperty("playerNewsResponse")
    // public List<PlayerNewsResponse> playerNewsResponse;

    @JsonProperty("playerProjectedPoints")
    public Double playerProjectedPoints;

    @JsonProperty("playerProjectedAssists")
    public Double playerProjectedAssists;

    @JsonProperty("playerProjectedRebounds")
    public Double playerProjectedRebounds;

    @JsonProperty("playerProjectedSteals")
    public Double playerProjectedSteals;

    @JsonProperty("playerProjectedBlocks")
    public Double playerProjectedBlocks;
}
