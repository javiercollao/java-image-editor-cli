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
        this.setR(255 - this.getR());
        this.setG(255 - this.getG());
        this.setB(255 - this.getB());
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

    @Override
    public String toString() {
        return "RGB {"+
               "x = "+ this.getPosX() +
               "y = "+ this.getPosY() +
               "r = "+ this.getR() +
               "g = "+ this.getG() +
               "b = "+ this.getB() +
               "depth = "+ this.getDepth() +
               "}";
    }
    
}
