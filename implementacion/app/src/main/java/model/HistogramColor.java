/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Javier Collao
 */
public abstract class HistogramColor {
    int times;
    public HistogramColor (int times) {
        this.times = times;
    }

    public int getTimes() {
        return times;
    }
    
    @Override
    public abstract String toString();
}
