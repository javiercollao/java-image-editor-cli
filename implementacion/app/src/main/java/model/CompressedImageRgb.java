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
public class CompressedImageRgb extends CompressedImage{
    List<Integer> rgb;
    public CompressedImageRgb (Image img, List<Integer> depths,  List<Integer> rgb) {
        super(img, depths);
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "[Imagen: "+ this.img.toString() +
                "  , Frequent Color: "+ this.rgb+
                "]";
    }

    @Override
    public Image decompress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Boolean isCompressed() {
        return true;
    }
}
