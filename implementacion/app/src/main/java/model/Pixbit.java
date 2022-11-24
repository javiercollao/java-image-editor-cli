/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Javier Collao
 */
public class Pixbit extends Pixel{
    int bit;

    public Pixbit (int posX, int posY, int bit, int depth){
        super(posX, posY, depth);
        this.bit = bit;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    
    @Override
    boolean isBit() {
        return true;
    }

    @Override
    boolean isPix() {
        return false;
    }

    @Override
    boolean isHex() {
        return false;
    }
    
    @Override
    void invertColor() {
        if(this.getBit() == 0){
            this.setBit(1);
        }else{
            this.setBit(0);
        }
    }

    @Override
    public String toString() {
        return "Bit { "+
               "x = "+ this.getPosX() +
               ", y = "+ this.getPosY() +
               ", bit = "+ this.getBit() +
               ", depth = "+ this.getDepth() +
               " }";
    }

    @Override
    String rgbToHex() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
