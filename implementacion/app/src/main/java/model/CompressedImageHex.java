/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delacoll
 */
public class CompressedImageHex extends CompressedImage{
    String hex;
    public CompressedImageHex (Image img, List<Integer> depths,  String hex) {
        super(img, depths);
        this.hex = hex;
    }

    @Override
    public String toString() {
        return "[Imagen: "+ this.img.toString() +
                "  , Frequent Color: "+ this.hex+
                "]";
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
            ((Pixhex) mylist.get(k)).setHex(this.hex);
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
                    newpixelsBool.add(j, Boolean.TRUE);
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
                Pixel p = new Pixhex(i,j,"vacio",0);
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
