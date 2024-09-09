package com.nhnacademy.movie;

import java.util.Set;

public class Movie {
    private final long movieId;
    private final String title;
    private final Set<String> genres;
    public Movie(long movieId, String title, Set<String> genres){
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }
    public long getMovieId() {
        return movieId;
    }
    public String getTitle(){
        return this.title;
    }
    public Set<String> getGenres(){
        return this.genres;
    }
    public String toString(){
        return this.getMovieId()+","+this.getTitle()+","+this.getGenres();
    }
}
