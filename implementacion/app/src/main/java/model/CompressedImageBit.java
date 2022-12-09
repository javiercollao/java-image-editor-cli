/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
}
