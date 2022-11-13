/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author delacoll
 */
public interface IImage {
    public boolean isBitmap();
    public boolean isPixmap();
    public boolean isHexmap();
    public boolean isCompressed();
    public void flipH();
    public void flipV();
    public void crop(int x1, int y1, int x2, int y2);
    public void imgRGBToHex();
    public void histogram();
    public void rotate90();
    public void compress();
    public void edit();
    public void invertColorBit();
    public void invertColorRGB();
    public void adjustChannel();
    public void imageToString();
    public void depthLayers();
    public void decompress();
}
