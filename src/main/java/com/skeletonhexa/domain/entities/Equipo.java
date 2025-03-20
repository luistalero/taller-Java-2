package com.skeletonhexa.domain.entities;

public class Equipo {
    private int id;
    private String name;
    private String yearfoundation;
    private String coach;
    public Equipo(int id, String name, String yearfoundation, String coach) {
        this.id = id;
        this.name = name;
        this.yearfoundation = yearfoundation;
        this.coach = coach;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getYearFound() {
        return yearfoundation;
    }
    public void setYearFound(String yearfoundation) {
            this.yearfoundation = yearfoundation;
    }
    public String getCoach() {
        return coach;
    }
    public void setCoach(String coach) {
        this.coach = coach;
    }


    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-23s | %-19s |", id, name, yearfoundation, coach);
    }
}

