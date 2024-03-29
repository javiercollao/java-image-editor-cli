/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Javier Collao
 */
public class Pixhex_19177246_CollaoCallpa extends Pixel_19177246_CollaoCallpa{
    String hex;
    
    public Pixhex_19177246_CollaoCallpa (int posX, int posY, String hex, int depth){
        super(posX, posY, depth);
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
    
    
    @Override
    void invertColor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    boolean isBit() {
        return false;
    }

    @Override
    boolean isPix() {
        return false;
    }

    @Override
    boolean isHex() {
        // 6 char?
        return true;
    }

    
    @Override
    public String toString() {
        return "["+
               "x = "+ this.getPosX() +
               ", y = "+ this.getPosY() +
               ", hex = "+ this.getHex() +
               ", depth = "+ this.getDepth() +
               "]\n";
    }

    @Override
    String rgbToHex() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
