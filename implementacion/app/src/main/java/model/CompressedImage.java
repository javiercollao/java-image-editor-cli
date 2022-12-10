/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Javier Collao
 */
public abstract class CompressedImage {
    Image img;
    List<Integer> depths;
    public CompressedImage (Image img, List<Integer> depths ) {
        this.img = img;
        this.depths = depths;
    }
    public abstract Boolean isCompressed();
    public abstract Image decompress();
     @Override
    public abstract String toString();
}
