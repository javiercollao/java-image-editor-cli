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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Boolean isCompressed() {
        return true;
    }
}
