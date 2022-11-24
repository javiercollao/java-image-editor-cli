/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package implementacion;
import java.util.Arrays;
import java.util.List;
import model.*;

public class App {
    
    public static void lab3() {
        // Ui lab3 = new Ui();
        // lab3.iniciar();
    }
    
    public static void lab4() {
        // Ui lab4 = new Ui();
        // lab4.iniciar();
    }

    public static void main(String[] args) {
        
        // instanciacion de una pixeles
        
        Pixel p1 = new Pixbit(0,0,1,4);
        Pixel p2 = new Pixbit(0,1,0,4);
        Pixel p3 = new Pixbit(1,0,1,3);
        Pixel p4 = new Pixbit(1,1,1,42);
        
        Pixel p5 = new Pixrgb(0,0,22,22,22,2);
        Pixel p6 = new Pixrgb(0,1,2,34,43,2);
        Pixel p7 = new Pixrgb(1,0,222,12,2,5);
        Pixel p8 = new Pixrgb(1,1,42,42,21,5);
        
        Pixel p9 = new Pixhex(0,0,"FFA412",2);
        Pixel p10 = new Pixhex(0,1,"A53BF1",2);
        Pixel p11 = new Pixhex(1,0,"FF5332",5);
        Pixel p12 = new Pixhex(1,1,"F452AB",5);
        
        List<Pixel> pixelsBit = Arrays.asList(p1,p2,p3,p4);
        List<Pixel> pixelsPix = Arrays.asList(p5,p6,p7,p8);
        List<Pixel> pixelsHex = Arrays.asList(p9,p10,p11,p12);
        
        // instanciacion de una imagen
        
        Image imagen1 = new Image(2,2,pixelsBit);
        Image imagen2 =  new Image(2,2,pixelsPix);
        Image imagen3 =  new Image(2,2,pixelsHex);

        // isBitmap, isPixmap, isHexmap  
        // System.out.print(imagen1.isBitmap());
        // System.out.print(imagen2.isPixmap());
        // System.out.print(imagen3.isHexmap());
             
        // isCompressed   
        // flipH
        
        System.out.print(imagen1);
        
        
        
        // flipV          
        // crop           
        // imgRGBToHex    
        // histogram      
        // rotate90       
        // compress       
        // edit           
        // invertColorBit 
        // invertColorRGB 
        // adjustChannel  
        // imageToString  
        // depthLayers    
        // decompress     
        
       
    }
}
