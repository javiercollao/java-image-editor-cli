/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Javier Collao
 */
public class Pixrgb extends Pixel{
    int r;
    int g;
    int b;
    
    public Pixrgb (int posX, int posY, int r, int g, int b, int depth){
        super(posX, posY, depth);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    void invertColor() {
        this.r = 255 - this.r;
        this.g = 255 - this.g;
        this.b = 255 - this.b;
    }

    @Override
    boolean isBit() {
        return false;
    }

    @Override
    boolean isPix() {
        return true;
    }

    @Override
    boolean isHex() {
        return false;
    }
    
}
