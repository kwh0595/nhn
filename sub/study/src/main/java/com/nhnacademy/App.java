package com.nhnacademy;
import java.io.IOException;
import static com.nhnacademy.String.ImportString.importString;
import static com.nhnacademy.String.JavaString.javaString;
import static com.nhnacademy.random.ImportRandom.importRandom;
import static com.nhnacademy.random.JavaRandom.javaRandom;

public class App {
    public static void main(String[] args) throws IOException {
        javaRandom();
        importRandom();
        javaString();
        importString();
    }
}
