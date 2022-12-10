/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Javier Collao
 */
public class Image implements IImage {
    public int width;
    public int height;
    public List<Pixel> pixels;

    public Image(int width, int height, List<Pixel> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
    }
    
    @Override
    public boolean isBitmap() {
        boolean result;
        List<Boolean> lista = new ArrayList<>();
        
        this.pixels.forEach(element -> {
            lista.add(element.isBit());
        });
        
        if(lista.contains(false)){
            result = false;
        }else{
            result = true;
        }
        
        return result;
    }

    @Override
    public boolean isPixmap() {
        boolean result;
        List<Boolean> lista = new ArrayList<>();
        
        this.pixels.forEach(element -> {
            lista.add(element.isPix());
        });
        
        if(lista.contains(false)){
            result = false;
        }else{
            result = true;
        }
        
        return result;
    }

    @Override
    public boolean isHexmap() {
        boolean result;
        List<Boolean> lista = new ArrayList<>();
        
        this.pixels.forEach(element -> {
            lista.add(element.isHex());
        });
        
        if(lista.contains(false)){
            result = false;
        }else{
            result = true;
        }
        
        return result;
    }

    @Override
    public boolean isCompressed() {
        return false;
    }

    @Override
    public void flipH() {
        int width = this.getWidth()-1;
        this.pixels.forEach(pixel -> {
            if(pixel.getPosX() == width){
                pixel.setPosX(0);
            }else if(pixel.getPosX() == 0){
                pixel.setPosX(width);
            }else{
                pixel.setPosX(width-pixel.getPosX());
            }
        }); 
    }

    @Override
    public void flipV() {
        int height = this.getHeight()-1;
        this.pixels.forEach(pixel -> {
            if(pixel.getPosY() == height){
                pixel.setPosY(0);
            }else if(pixel.getPosY() == 0){
                pixel.setPosY(height);
            }else{
                pixel.setPosY(height-pixel.getPosY());
            }
        }); 
    }

    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        List<Pixel> lista = new ArrayList<>();
        this.pixels.forEach(pixel -> {
            if(pixel.getPosX() >= x1 && pixel.getPosX() <= x2 && pixel.getPosY()<= y1){
                lista.add(pixel);
            }else{
                lista.add(null);
            }
        });
        lista.removeIf(pixel -> (pixel == null));
        this.setPixels(lista);
        this.setWidth((x2-x1)+1);
        this.setHeight(this.height-((this.height-1)-y2));
    }

    @Override
    public void imgRGBToHex() {
        List<Pixel> lista = new ArrayList<>();
        if(this.isPixmap()){
            this.pixels.forEach(pixel -> {
                Pixel p = new Pixhex(pixel.getPosX(),pixel.getPosY(), pixel.rgbToHex(), pixel.getDepth());
                lista.add(p);
            });
            this.setPixels(lista);
        }else{
            this.setPixels(this.pixels);
        }
    }

    @Override
    public Histogram histogram() { 
        List<HistogramColor> listaFrencuenciaColores = null;
        if(this.isBitmap()){  
            List<Integer> colors = new ArrayList<>();
            this.pixels.forEach(pixel -> {
                int bit = ((Pixbit)pixel).getBit();
                colors.add(bit);
            });
            listaFrencuenciaColores = filterBit(colors);
        }else if(this.isPixmap()){
            List<List<Integer>> colors;
            colors = new ArrayList<>();
            this.pixels.forEach(pixel -> {
                List<Integer> color = ((Pixrgb)pixel).getRGB();
                colors.add(color);
            }); 
            listaFrencuenciaColores = filterRgb(colors);
        }else{
            List<String> colors;
            colors = new ArrayList<>();
            this.pixels.forEach(pixel -> {
                String hex = ((Pixhex)pixel).getHex();
                colors.add(hex);
            }); 
            listaFrencuenciaColores = filterHex(colors);
        }
        Histogram histo;
        histo = new Histogram(listaFrencuenciaColores);
        return histo;  
    }
    
    public List<HistogramColor> filterBit(List<Integer> lista){
        List<HistogramColor> histo = new ArrayList<>();
 
        for (int i = 0; i < lista.size(); i++){
            int flag = 0;
            int count = 0;

            for (int j = i+1; j < lista.size(); j++){
                if (lista.get(i).equals(lista.get(j))){
                    flag = 1;
                    break;
                }
            }
 
            if (flag == 1)
                continue;

            for (int j = 0;j<=i;j++){
                if (lista.get(i).equals(lista.get(j)))
                    count++;
            }
            HistogramColorBit colorBit;
            colorBit = new HistogramColorBit(lista.get(i),count); 
            histo.add(colorBit);
        }
       
        return histo;
    }
    
    public List<HistogramColor> filterRgb(List<List<Integer>> lista){
        List<HistogramColor> histo = new ArrayList<>();
 
        for (int i = 0; i < lista.size(); i++){
            int flag = 0;
            int count = 0;

            for (int j = i+1; j < lista.size(); j++){
                if (lista.get(i).equals(lista.get(j))){
                    flag = 1;
                    break;
                }
            }
 
            if (flag == 1)
                continue;

            for (int j = 0;j<=i;j++){
                if (lista.get(i).equals(lista.get(j)))
                    count++;
            }
            HistogramColorRgb colorRgb;
            colorRgb = new HistogramColorRgb(lista.get(i),count); 
            histo.add(colorRgb);
        }
       
        return histo;
    }
   
    public List<HistogramColor> filterHex(List<String> lista){
        List<HistogramColor> histo = new ArrayList<>();
 
        for (int i = 0; i < lista.size(); i++){
            int flag = 0;
            int count = 0;

            for (int j = i+1; j < lista.size(); j++){
                if (lista.get(i).equals(lista.get(j))){
                    flag = 1;
                    break;
                }
            }
 
            if (flag == 1)
                continue;

            for (int j = 0;j<=i;j++){
                if (lista.get(i).equals(lista.get(j)))
                    count++;
            }
            HistogramColorHex colorHex;
            colorHex = new HistogramColorHex(lista.get(i),count); 
            histo.add(colorHex);
        }
       
        return histo;
    }

    @Override
    public void rotate90() { 
        this.pixels.forEach(pixel -> {
            int newPosX = pixel.getPosY();
            int newPosY = pixel.getPosX();
            pixel.setPosX(newPosX);
            pixel.setPosY(newPosY);
        });  
        this.flipH();
    }

    @Override
    public CompressedImage compress() { 
        List<Integer> listaDepths = new ArrayList<>();
        if(this.isBitmap()){  
            Image img = new Image(this.width,this.height, mostFrecuencyColorBitNegativeList());
            this.mostFrecuencyColorBitList().forEach(depth -> {
                listaDepths.add(depth.getDepth());
            });
            CompressedImage cimg = new CompressedImageBit(img,listaDepths, this.mostRepeatedColorBit());  
            return cimg;
        }else if(this.isPixmap()){
            Image img = new Image(this.width,this.height, mostFrecuencyColorRgbNegativeList());
            this.mostFrecuencyColorRgbList().forEach(depth -> {
                listaDepths.add(depth.getDepth());
            });
            CompressedImage cimg = new CompressedImageRgb(img,listaDepths, this.mostRepeatedColorRgb());  
            return cimg;
        }else{
            Image img = new Image(this.width,this.height, mostFrecuencyColorHexNegativeList());
            this.mostFrecuencyColorHexList().forEach(depth -> {
                listaDepths.add(depth.getDepth());
            });
            CompressedImage cimg = new CompressedImageHex(img, listaDepths, this.mostRepeatedColorHex());  
            return cimg;
        }
    }
    
    public Integer mostRepeatedColorBit(){
        List<Integer> listaFrecuencia = new ArrayList<Integer>();
        this.histogram().getHisto().forEach(colorHisto -> {
            listaFrecuencia.add(colorHisto.getTimes());
        });
        Collections.sort(listaFrecuencia, Collections.reverseOrder());
        int maxColorTimes = listaFrecuencia.get(0);
        
        HistogramColor color = this.histogram().getHisto().stream().filter(h -> h.getTimes() == maxColorTimes).toList().get(0);
        HistogramColorBit colorBit = (HistogramColorBit) color;
        
        return colorBit.getBit();
    }
    
    public List<Integer> mostRepeatedColorRgb(){
        List<Integer> listaFrecuencia = new ArrayList<Integer>();
        this.histogram().getHisto().forEach(colorHisto -> {
            listaFrecuencia.add(colorHisto.getTimes());
        });
        Collections.sort(listaFrecuencia, Collections.reverseOrder());
        int maxColorTimes = listaFrecuencia.get(0);
        
        HistogramColor color = this.histogram().getHisto().stream().filter(h -> h.getTimes() == maxColorTimes).toList().get(0);
        HistogramColorRgb colorRgb = (HistogramColorRgb) color;
        
        return colorRgb.getRgb();
    }
    
      public String mostRepeatedColorHex(){
        List<Integer> listaFrecuencia = new ArrayList<Integer>();
        this.histogram().getHisto().forEach(colorHisto -> {
            listaFrecuencia.add(colorHisto.getTimes());
        });
        Collections.sort(listaFrecuencia, Collections.reverseOrder());
        int maxColorTimes = listaFrecuencia.get(0);
        
        HistogramColor color = this.histogram().getHisto().stream().filter(h -> h.getTimes() == maxColorTimes).toList().get(0);
        HistogramColorHex colorHex = (HistogramColorHex) color;
        
        return colorHex.getHex();
    }
    
 
    
    public List<Pixel> mostFrecuencyColorBitList(){
        List<Pixel> lista;
        
        int colorMax = this.mostRepeatedColorBit();
        lista =  (List<Pixel>) this.pixels.stream().filter(pixel-> {
            return colorMax == ((Pixbit) pixel).getBit();
        }).toList();
        
        return lista;
         
    }
    
    public List<Pixel> mostFrecuencyColorBitNegativeList(){
        List<Pixel> lista;
        
        int colorMax = this.mostRepeatedColorBit();
        lista =  (List<Pixel>) this.pixels.stream().filter(pixel-> {
            return colorMax != ((Pixbit) pixel).getBit();
        }).toList();
        
        return lista;
        
    }
    
    
    public List<Pixel> mostFrecuencyColorRgbList(){
        List<Pixel> lista;
        
        List<Integer> colorMax = this.mostRepeatedColorRgb();
        lista =  (List<Pixel>) this.pixels.stream().filter(pixel-> {
            return colorMax.equals(((Pixrgb) pixel).getRGB());
        }).toList();
        
        return lista;
         
    }
    
    
     public List<Pixel> mostFrecuencyColorRgbNegativeList(){
        List<Pixel> lista;
        
        List<Integer> colorMax = this.mostRepeatedColorRgb();
        lista =  (List<Pixel>) this.pixels.stream().filter(pixel-> {
            return !colorMax.equals(((Pixrgb) pixel).getRGB());
        }).toList();
        
        return lista;
        
    }
     
     
     
     
    public List<Pixel> mostFrecuencyColorHexList(){
        List<Pixel> lista;
        
        String colorMax = this.mostRepeatedColorHex();
        lista =  (List<Pixel>) this.pixels.stream().filter(pixel-> {
            return colorMax.equals(((Pixhex) pixel).getHex());
        }).toList();
        
        return lista;
         
    }
    
    
     public List<Pixel> mostFrecuencyColorHexNegativeList(){
        List<Pixel> lista;
        
        String colorMax = this.mostRepeatedColorHex();
        lista =  (List<Pixel>) this.pixels.stream().filter(pixel-> {
            return !colorMax.equals(((Pixhex) pixel).getHex());
        }).toList();
        
        return lista;
        
    }
    


    @Override
    public void invertColorBit() {
        this.pixels.forEach(pixel -> { 
            pixel.invertColor();
        }); 
    }

    @Override
    public void invertColorRGB() {
        this.pixels.forEach(pixel -> { 
            pixel.invertColor();
        }); 
    }

    @Override
    public void changePixel(Pixel p) {
        List<Pixel> lista = new ArrayList<>();
        this.pixels.forEach(pixel -> { 
            if(pixel.getPosX() == p.getPosX() && pixel.getPosY() == p.getPosY()){
                lista.add(p);
            }else{
                lista.add(pixel);
            }
        }); 
        this.setPixels(lista);   
    }

    @Override
    public String toString() { 
        List<String> lista = new ArrayList<>();
        StringBuilder sb;
        sb = new StringBuilder();

        this.pixels.forEach(pixel -> {
           lista.add(pixel.toString());
        });
        
        lista.forEach(sb::append);
        String concatString = sb.toString();
        
        return concatString;
    }
    

    @Override
    public void depthLayers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
}
