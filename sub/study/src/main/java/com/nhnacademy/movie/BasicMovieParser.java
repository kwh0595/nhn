package com.nhnacademy.movie;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicMovieParser implements MovieParser{
    List<Movie> list = new ArrayList<>();
    @Override
    public List<Movie> parse() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getMovieFileAsStream()));
        String str = "";
        String movie[];
        String genre[];
        bufferedReader.readLine();
        while((str=bufferedReader.readLine())!=null) {
            String s = str; s.trim();
            movie = s.split(",");
            genre = movie[2].split("\\|");

            Set<String> genres = new HashSet<String>();
            for(String i : genre){
                genres.add(i);
            }
            Movie movies = new Movie(Long.parseLong(movie[0]),movie[1],genres);
            list.add(movies);
        }
        return list;
    }
    @Override
    public InputStream getMovieFileAsStream() {
        return MovieParser.super.getMovieFileAsStream();
    }
}
