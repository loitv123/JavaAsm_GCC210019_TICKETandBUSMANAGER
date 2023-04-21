/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Win10
 */
public class busModel implements Serializable{
    
    private String busID;
    private String busLicense;
    private int seat = 30;
    private String time;
    private String trip;
    private int price;
    
    public busModel(String busID, String busLicense, int seat, String time, String trip, int price) {
        this.busID = busID;
        this.busLicense = busLicense;
        this.seat = seat;
        this.time = time;
        this.trip = trip;
        this.price = price;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getBusLicense() {
        return busLicense;
    }

    public void setBusLicense(String busLicense) {
        this.busLicense = busLicense;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
