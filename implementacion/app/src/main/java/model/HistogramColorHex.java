/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Javier Collao
 */
public class HistogramColorHex extends HistogramColor {
    String hex;
    public HistogramColorHex (String hex, int times){
        super(times);
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    @Override
    public String toString() {
        return "[Color: "+ this.hex +
                " , Times: "+ this.times+
                "]";
    }
    
    
}
