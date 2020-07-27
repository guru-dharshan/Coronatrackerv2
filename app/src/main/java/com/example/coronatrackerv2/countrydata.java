package com.example.coronatrackerv2;

public class countrydata {

    private String flag, country, cases, todayCases, deaths, todayDeaths, recovered, todayRecoverd, active, critical, tests;

    public countrydata(String flag, String country, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String todayRecoverd, String active, String critical, String tests) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecoverd = todayRecoverd;
        this.active = active;
        this.critical = critical;
        this.tests = tests;
    }

    public String getFlag() {
        return flag;
    }

    public String getCountry() {
        return country;
    }

    public String getCases() {
        return cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getTodayRecovered() {
        return todayRecoverd;
    }

    public String getActive() {
        return active;
    }

    public String getCritical() {
        return critical;
    }

    public String getTests() {
        return tests;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setTodayRecoverd(String todayRecoverd) {
        this.todayRecoverd = todayRecoverd;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }
}

