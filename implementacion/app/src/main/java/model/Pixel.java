/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Javier Collao
 */
public abstract class Pixel {
    int posX;
    int posY;
    int depth;
    
    public Pixel (int x, int y, int z) {
		this.posX = x;
		this.posY = y;
                this.depth = z;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getDepth() {
        return depth;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    abstract boolean isBit();
    abstract boolean isPix();
    abstract boolean isHex();
    
    abstract void invertColor();
    
}
