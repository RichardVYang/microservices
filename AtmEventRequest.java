/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yang.microservice.event.request;

/**
 *
 * @author Richard Yang
 */
import java.util.Date;

/* json format data
{
"date":"2016-03-16 08:15:30",
"location":"Des Moines, IA",
"atmId":"ABC123",
"action":"deposit",
"amount":1234567,
"isCompleted":true,
"userId":"YNG123",
"corelationId":"4567"
}
 */
public class AtmEventRequest {

    private String date;  // date and time stamp event is initiated
    private String location;  // location of ATM or where transaction is taking place
    private String atmId;  // ATM unique identifier
    private String action;  // event action such as deposit, withdraw, transfter fund
    private long amount; // amount to deposit/withdraw or transfer
    private String userId; // Unique user identification
    private String corelationId; // corelate multiple events in a session with a userId

    public String getCorelationId() {
        return corelationId;
    }

    public void setCorelationId(String corelationId) {
        this.corelationId = corelationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
