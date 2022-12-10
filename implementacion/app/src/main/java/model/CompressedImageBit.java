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
public class CompressedImageBit extends CompressedImage{
    int bit;
    public CompressedImageBit (Image img, List<Integer> depths, int bit) {
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
    public Image decompress() {
       
       List<Pixel> mylist = this.regenerarPixeles();
       for (int k = 0; k < this.img.getPixels().size() ; k++){
           mylist.add(this.img.getPixels().get(k));
       }
       Image imagen = new Image(this.img.getWidth(),this.img.getHeight(), mylist);
       return imagen;
    }
    
    public List<Pixel> regenerarPixeles(){
        List<Pixel> mylist = this.filtrarPixeles();
        for (int k = 0; k < this.filtrarPixeles().size() ; k++){
            mylist.get(k).setDepth(this.depths.get(k));
            ((Pixbit) mylist.get(k)).setBit(this.bit);
        }
        return mylist;
    }
    
    
    public List<Pixel> filtrarPixeles(){
        List<Pixel> newpixels = new ArrayList<>();
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
    
    
    public List<Pixel> coordenadas() {
        List<Pixel> pixelsGenerados = new ArrayList<>();
        for(int i=0; i < this.img.getWidth(); i++){
            for(int j = 0; j < this.img.getHeight(); j++ ){
                Pixel p = new Pixbit(i,j,0,0);
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
