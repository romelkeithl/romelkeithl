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
public class Process {
    private String name;
    private int burstTime;
    private int arrivalTime;
    private int priority;
    public Process(String name, int burstTime, int arrivalTime,int priority) {
        this.name = name;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority=priority;
    }
    
    public  void setProcess(String name){
    this.name=name;
    }
    
    public void setBurst(int burstTime){
    this.burstTime=burstTime;
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
    
        public int getPriority() {
        return priority;
    }
    
        
 public Boolean anyProcessHasRemainingBurst(ArrayList<Process> processes) {
    for (Process process : processes) {
        if (process.getTimeBurst() > 0) {
            return true;
        }
    }
    return false;
}

}
