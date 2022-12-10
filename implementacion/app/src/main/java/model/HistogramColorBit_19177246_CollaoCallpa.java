/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Javier Collao
 */
public class HistogramColorBit_19177246_CollaoCallpa extends HistogramColor_19177246_CollaoCallpa{
     int bit;
     public HistogramColorBit_19177246_CollaoCallpa (int bit, int times) {
        super(times);
        this.bit = bit;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }
    
    @Override
    public String toString() {
        return "[Color: "+ this.bit +
                "  , Times: "+ this.times+
                "]";
    }
}
