package com.amandaw.covid19statistics.service;

import com.amandaw.covid19statistics.entity.AreaState;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataFetchService {

    private static String COVID_19_DATA = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private static List<AreaState> areaStateList;
//    private static Reader in;
    private static StringReader in;


    public DataFetchService() throws IOException, InterruptedException {
//        in = new FileReader("src/main/resources/time_series_covid19_confirmed_global.csv");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(COVID_19_DATA)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        in = new StringReader(response.body());
    }

//    @Scheduled(cron = " * * 1 * * * ")
    public List<AreaState> FetchData() throws IOException {
        List<AreaState> newList = new ArrayList<>();

//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(COVID_19_DATA)).build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
//        StringReader in = new StringReader(response.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            AreaState areaState = new AreaState();
            areaState.setProvince_State(record.get("Province/State"));
            areaState.setCountry_Region(record.get("Country/Region"));
            areaState.setLatestCases(Integer.parseInt(record.get(record.size()-1)));
            areaState.setNewCases(Integer.parseInt(record.get(record.size()-1))-Integer.parseInt(record.get(record.size()-2)));
            newList.add(areaState);
        }

        this.areaStateList = newList;
        return areaStateList;
    }
}
