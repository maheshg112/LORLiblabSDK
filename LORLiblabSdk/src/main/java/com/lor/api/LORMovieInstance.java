package com.lor.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LORMovieInstance {
	public  Movie[] movies;
	public  Integer total;
	public  Integer limit;
	public  Integer offset;
	public  Integer page;
	public  Integer pages;
	
	public LORMovieInstance(@JsonProperty("docs") Movie[] docs,
            @JsonProperty("total") Integer total,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("offset") Integer offset,
            @JsonProperty("page") Integer page,
            @JsonProperty("pages") Integer pages
           
            ) {
    this.movies = docs;
    this.total = total;
    this.limit = limit;
    this.offset = offset;
    this.page = page;
    this.pages = pages;
    }

	

	
	public Movie getMovie(String id) {
		Movie movie = null;
		
		for(Movie m : movies) {
		    if(m._id.equalsIgnoreCase(id)) {
		    	movie = m;
		    	break;
		    }
		}
		
		return movie;
	}
}
