package com.nhnacademy.movie;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApacheCommonsCsvMovieParser implements MovieParser {
    List<Movie> list = new ArrayList<>();

    @Override
    public List<Movie> parse() throws IOException {
        BufferedReader csvData = new BufferedReader(new InputStreamReader(getMovieFileAsStream()));
        CSVParser parser = CSVParser.parse(csvData, CSVFormat.EXCEL);

        List<CSVRecord> csvRecordList = parser.getRecords();

        for (int record_i = 1; record_i < csvRecordList.size(); record_i++) {
            CSVRecord csvRecord = csvRecordList.get(record_i);
            long movieId = Long.parseLong(csvRecord.get(0));
            String title = csvRecord.get(1);
            Set<String> genres = Arrays.stream(csvRecord.get(2).split("\\|")).collect(Collectors.toSet());
            Movie movies = new Movie(movieId, title, genres);
            list.add(movies);
        }

        return list;
    }
}