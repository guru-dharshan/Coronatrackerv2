package com.example.coronatrackerv2.DATA;

public class statedata {
    private String name,active,cured,death,total;

    public statedata(String name, String active, String cured, String death, String total) {
        this.name = name;
        this.active = active;
        this.cured = cured;
        this.death = death;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCured() {
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
