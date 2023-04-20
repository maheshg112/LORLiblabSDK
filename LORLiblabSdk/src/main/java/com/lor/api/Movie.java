package com.lor.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
	public  String _id;
	public  String name;
	public  Integer runtimeInMinutes;
	public  Integer budgetInMillions;
	public  Integer boxOfficeRevenueInMillions;
	public  Integer academyAwardNominations;
	public  Integer academyAwardWins;
	public  Integer rottenTomatoesScore;

	public Movie(@JsonProperty("_id") String _id,
                @JsonProperty("name") String name,
                @JsonProperty("runtimeInMinutes") Integer runtimeInMinutes,
                @JsonProperty("budgetInMillions") Integer budgetInMillions,
                @JsonProperty("boxOfficeRevenueInMillions") Integer boxOfficeRevenueInMillions,
                @JsonProperty("academyAwardNominations") Integer academyAwardNominations,
                @JsonProperty("academyAwardWins") Integer academyAwardWins,
                @JsonProperty("rottenTomatoesScore") Integer rottenTomatoesScore) {
        this._id = _id;
        this.name = name;
        this.runtimeInMinutes = runtimeInMinutes;
        this.budgetInMillions = budgetInMillions;
        this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
        this.academyAwardNominations = academyAwardNominations;
        this.academyAwardWins = academyAwardWins;
        this.rottenTomatoesScore = rottenTomatoesScore;
    }    
}
