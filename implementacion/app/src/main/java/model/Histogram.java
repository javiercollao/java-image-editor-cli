/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier Collao
 */
public class Histogram {
    public List<HistogramColor> histo;
    
    public Histogram (List<HistogramColor> histo) {
        this.histo = histo; 
    }

    public List<HistogramColor> getHisto() {
        return histo;
    }

    public void setHisto(List<HistogramColor> histo) {
        this.histo = histo;
    }
    
    @Override
    public String toString() { 
        List<String> lista = new ArrayList<>();
        StringBuilder sb;
        sb = new StringBuilder();

        lista.add("\nHistogram:");
        this.histo.forEach(histogramColor -> {
           lista.add(histogramColor.toString());
        });
        lista.add("\n");
        lista.forEach(sb::append);
        String concatString = sb.toString();
        
        return concatString;
    }

}
