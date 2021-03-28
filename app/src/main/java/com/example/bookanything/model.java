package com.example.bookanything;

public class model {

    String name,date,time,uName;

    model(){

    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public model(String name, String date, String time, String uName) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.uName = uName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
