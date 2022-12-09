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
public class CompressedImageBit extends CompressedImage{
    int bit;
    public CompressedImageBit (Image img, List<Integer> depths, int bit) {
        super(img, depths);
        this.bit = bit;
    }
    
    @Override
    public String toString() {
        return "[Imagen: "+ this.img.toString() +
                "  , Frequent Color: "+ this.bit+
                "]";
    }

    @Override
    public Image decompress() {
            
       //this.img.getPixels();
       
       for(int i = 0; i < this.img.getPixels().size(); i++){
           
           for(int j = 0; j < this.coordenadas().size(); j++){
               if(this.img.getPixels().get(i).getPosX() != this.coordenadas().get(j).getPosX() && this.img.getPixels().get(i).getPosY() != this.coordenadas().get(j).getPosY()){
               
               }
           
           }
       }
       
       Image im = new Image(2,2, this.coordenadas());
       return im;
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
