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
public class TicketModel implements Serializable{
    private int TicID;
//    private static int counter = 0;
    private int customerPhone;
    private int TicPrice;
    private String BusCode; 

    public TicketModel(int TicID, int customerPhone, int TicPrice, String txtBusCode) {
        this.TicID = TicID;
        this.customerPhone = customerPhone;
        this.TicPrice = TicPrice;
        this.BusCode = txtBusCode;
    }


//    public String getTicID() {
//        return TicID;
//    }
//
//    public void setTicID(String TicID) {
//        this.TicID = TicID;
//    }
//
//
//
//    public int getCustomerPhone() {
//        return customerPhone;
//    }
//
//    public void setCustomerPhone(int customerPhone) {
//        this.customerPhone = customerPhone;
//    }
//
//    public int getTicPrice() {
//        return TicPrice;
//    }
//
//    public void setTicPrice(int TicPrice) {
//        this.TicPrice = TicPrice;
//    }
//
//    public String getTxtBusCode() {
//        return BusCode;
//    }
//
//    public void setTxtBusCode(String txtBusCode) {
//        this.BusCode = txtBusCode;
//    }
//    

    public int getTicID() {
        return TicID;
    }

    public void setTicID(int TicID) {
        this.TicID = TicID;
    }

  

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getTicPrice() {
        return TicPrice;
    }

    public void setTicPrice(int TicPrice) {
        this.TicPrice = TicPrice;
    }

    public String getBusCode() {
        return BusCode;
    }

    public void setBusCode(String BusCode) {
        this.BusCode = BusCode;
    }

}
