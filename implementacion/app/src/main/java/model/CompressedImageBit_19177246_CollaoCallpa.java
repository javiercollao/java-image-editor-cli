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
public class CompressedImageBit_19177246_CollaoCallpa extends CompressedImage_19177246_CollaoCallpa{
    int bit;
    public CompressedImageBit_19177246_CollaoCallpa (Image_19177246_CollaoCallpa img, List<Integer> depths, int bit) {
        super(img, depths);
        this.bit = bit;
    }
    
    @Override
    public String toString() {
        return "\n[Imagen: "+ this.img.toString() +
                "  , Frequent Color: "+ this.bit+
                "]\n";
    }

    @Override
    public Image_19177246_CollaoCallpa decompress() {
       
       List<Pixel_19177246_CollaoCallpa> mylist = this.regenerarPixeles();
       for (int k = 0; k < this.img.getPixels().size() ; k++){
           mylist.add(this.img.getPixels().get(k));
       }
       Image_19177246_CollaoCallpa imagen = new Image_19177246_CollaoCallpa(this.img.getWidth(),this.img.getHeight(), mylist);
       return imagen;
    }
    
    public List<Pixel_19177246_CollaoCallpa> regenerarPixeles(){
        List<Pixel_19177246_CollaoCallpa> mylist = this.filtrarPixeles();
        for (int k = 0; k < this.filtrarPixeles().size() ; k++){
            mylist.get(k).setDepth(this.depths.get(k));
            ((Pixbit_19177246_CollaoCallpa) mylist.get(k)).setBit(this.bit);
        }
        return mylist;
    }
    
    
    public List<Pixel_19177246_CollaoCallpa> filtrarPixeles(){
        List<Pixel_19177246_CollaoCallpa> newpixels = new ArrayList<>();
        List<Boolean> newpixelsBool = new ArrayList<>();
        for (int k = 0; k < this.coordenadas().size() ; k++){
            newpixelsBool.add(false);
        }
        for (int i = 0; i < this.img.getPixels().size(); i++){
            for (int j = 0; j < this.coordenadas().size() ; j++){
                if (this.img.getPixels().get(i).getPosX() == this.coordenadas().get(j).getPosX() && this.img.getPixels().get(i).getPosY() == this.coordenadas().get(j).getPosY() && newpixelsBool.get(j).equals(false)){
                    newpixelsBool.set(j, Boolean.TRUE);
                }
            }
        }
        for (int j = 0; j < this.coordenadas().size() ; j++){
            if(newpixelsBool.get(j).equals(false)){
                newpixels.add(this.coordenadas().get(j));
            } 
        }
        return newpixels;     
    }
    
    
    public List<Pixel_19177246_CollaoCallpa> coordenadas() {
        List<Pixel_19177246_CollaoCallpa> pixelsGenerados = new ArrayList<>();
        for(int i=0; i < this.img.getWidth(); i++){
            for(int j = 0; j < this.img.getHeight(); j++ ){
                Pixel_19177246_CollaoCallpa p = new Pixbit_19177246_CollaoCallpa(i,j,0,0);
                pixelsGenerados.add(p);
            }
        }
        return pixelsGenerados;
    }

    @Override
    public Boolean isCompressed() {
        return true;
    }
 
 
}
