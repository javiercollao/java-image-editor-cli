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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            this.setPixels(lista);
        }
    }

    @Override
    public void histogram() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void rotate90() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void compress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void invertColorBit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void invertColorRGB() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adjustChannel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public void decompress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
