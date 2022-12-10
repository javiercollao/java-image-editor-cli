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
public abstract class CompressedImage_19177246_CollaoCallpa {
    Image_19177246_CollaoCallpa img;
    List<Integer> depths;
    public CompressedImage_19177246_CollaoCallpa (Image_19177246_CollaoCallpa img, List<Integer> depths ) {
        this.img = img;
        this.depths = depths;
    }
    public abstract Boolean isCompressed();
    public abstract Image_19177246_CollaoCallpa decompress();
     @Override
    public abstract String toString();
}
