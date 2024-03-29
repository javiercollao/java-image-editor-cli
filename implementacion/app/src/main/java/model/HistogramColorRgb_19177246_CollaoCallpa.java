/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Javier Collao
 */
public class HistogramColorRgb_19177246_CollaoCallpa extends HistogramColor_19177246_CollaoCallpa {
    List<Integer> rgb;
    
    public HistogramColorRgb_19177246_CollaoCallpa (List<Integer> rgb, int times){
        super(times);
        this.rgb = rgb;
    }

    public List<Integer> getRgb() {
        return rgb;
    }

    public void setRgb(List<Integer> rgb) {
        this.rgb = rgb;
    }

   
   @Override
    public String toString() {
        return "[Color: "+ this.rgb.get(0) + ", " + this.rgb.get(1) + ", " + this.rgb.get(2) +
                " , Times: "+ this.times+
                "]";
    }
    
    
}
