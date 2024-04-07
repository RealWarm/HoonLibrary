package com.group.libraryapp.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class UsingLib {

    public static void main(String[] args) throws CsvException, IOException {
        CSVReader csvReader = new CSVReader(new FileReader("data/wine.csv"));
        List<String[]> lines = csvReader.readAll();
        lines.forEach(line -> System.out.println(String.join(",", line)));
    }
}
