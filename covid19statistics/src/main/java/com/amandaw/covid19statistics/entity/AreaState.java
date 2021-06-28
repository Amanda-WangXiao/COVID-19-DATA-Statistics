package com.amandaw.covid19statistics.entity;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
public class AreaState implements Serializable {
    private String Province_State;
    private String Country_Region;
    private int LatestCases;
    private int NewCases;

    public String getProvince_State() {
        return Province_State;
    }

    public void setProvince_State(String province_State) {
        Province_State = province_State;
    }

    public String getCountry_Region() {
        return Country_Region;
    }

    public void setCountry_Region(String country_Region) {
        Country_Region = country_Region;
    }

    public int getLatestCases() {
        return LatestCases;
    }

    public void setLatestCases(int latestCases) {
        LatestCases = latestCases;
    }

    public int getNewCases() {
        return NewCases;
    }

    public void setNewCases(int newCases) {
        NewCases = newCases;
    }

    @Override
    public String toString() {
        return "AreaState{" +
                "Province_State='" + Province_State + '\'' +
                ", Country_Region='" + Country_Region + '\'' +
                ", LatestCases=" + LatestCases +
                ", NewCases=" + NewCases +
                '}';
    }
}
