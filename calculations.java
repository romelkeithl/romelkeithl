/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lugo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class calculations {
    private String name;
    private int burstTime;
    private int arrivalTime;
    private int turnaround;
    private int waiting;
    private int priority;
    public calculations(String name, int burstTime, int arrivalTime,int turnaround,int waiting, int priority) {
        this.name = name;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.turnaround=turnaround;
        this.waiting=waiting;
        this.priority=priority;
    }
    public String getProcess() {
        return name;
    }

    public int getTimeBurst() {
        return burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getWaiting(){
    return waiting;
    }
    
    public int getTurnAround(){
    return turnaround;
    }
    
    public int getPriority(){
    return priority;}
}
