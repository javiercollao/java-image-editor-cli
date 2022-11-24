/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author delacoll
 */
public class Pixhex extends Pixel{
    String hex;
    
    public Pixhex (int posX, int posY, String hex, int depth){
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
        return true;
    }
    
}
