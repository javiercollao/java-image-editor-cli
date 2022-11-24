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
    
    public String hexColor(int n){
        String result;
        if(n>= 0 && n<= 9){
            result = ""+ n + "";
        }else if(n == 10){
            result = "A";
        }else if(n == 11){
            result = "B";
        }else if(n == 12){
            result = "C";
        }else if(n == 13){
            result = "D";
        }else if(n == 14){
            result = "E";
        }else if(n == 15){
            result = "F";
        }else{
            result = null;
        }
        return result;
    }
    
    public String toHex(int n){
        int n1 = (n/16)%16;
        int n2 = n%16;
        String c1 = this.hexColor(n1);
        String c2 = this.hexColor(n2);
        return c1+c2;
    }
    
    public String rgbToHex() {
        return this.toHex(this.r)+this.toHex(this.g)+this.toHex(this.b);
    }

    @Override
    public String toString() {
        return "RGB { "+
               "x = "+ this.getPosX() +
               ", y = "+ this.getPosY() +
               ", R = "+ this.getR() +
               ", G = "+ this.getG() +
               ", B = "+ this.getB() +
               ", depth = "+ this.getDepth() +
               " }";
    }

     
    
}
