/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author Win10
 */
public class ticket {

    private String ticketId;
    private String customerName;
    private String cusPhone;
    private String Stop;
    private String total;
//    Bus 
    private String bus;

    public ticket(String ticketId, String customerName, String cusPhone, String Stop, String total) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.cusPhone = cusPhone;
        this.Stop = Stop;
        this.total = total;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getStop() {
        return Stop;
    }

    public void setStop(String Stop) {
        this.Stop = Stop;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
