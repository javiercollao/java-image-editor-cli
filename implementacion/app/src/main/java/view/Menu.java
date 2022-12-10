/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.*;

/**
 *
 * @author Javier Collao
 */
public class Menu implements IMenu{
    
    Menu menu;
    Scanner input = new Scanner(System.in);
    Image image;
    Boolean compressBoolean = false;
    CompressedImage cimage;

    public void setImage(Image image) {
        this.image = image;
    }

    public void setCompressBoolean(Boolean compressBoolean) {
        this.compressBoolean = compressBoolean;
    }

    public void setCimage(CompressedImage cimage) {
        this.cimage = cimage;
    }
     
    
    /* Inicializa el menu principal */
    @Override
    public void iniciar() { 
        int opcion = 0;
        do{ 
            System.out.println("\n### Manipulador de imágenes ###");
            System.out.println("Escoja su opción: ");
            System.out.println("1. Nueva imagen");
            System.out.println("2. Modificar y visualizar una imagen");
            System.out.println("3. Salir");
                
            try {
                System.out.println("Introduzca su eleccion: ");
                opcion = this.input.nextInt();
                switch (opcion) {
                    case 1: 
                            this.crearNuevaImagen();
                            break;
                    case 2: 
                            this.cargarImagen();
                            break; 
                    case 3: 
                            opcion = 3;
                            break;
                    default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;    
                    }

                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    this.input.next();
                }
            }while (opcion != 3);
    }

    @Override
    public void crearNuevaImagen() { 
        int opcion = 0;
        do{ 
            System.out.println("\n### Manipulador de imágenes ###");
            System.out.println("Escoja su opción: ");
            System.out.println("1. Crear bitmap");
            System.out.println("2. Crear pixmap");
            System.out.println("3. Crear hexmap"); 
            System.out.println("4. Volver");
                
            try {
                System.out.println("Introduzca su eleccion: ");
                opcion = this.input.nextInt();
                switch (opcion) {
                    case 1: 
                            this.crearImagenTipoBitmap();
                            break; 
                    case 2: 
                            this.crearImagenTipoPixmap();
                            break;
                    case 3: 
                            this.crearImagenTipoHexmap();
                            break; 
                    case 4: 
                            opcion = 4;
                            break;
                    default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;    
                    } 
                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    this.input.next();
                }
            }while (opcion != 4); 
    }
    
    @Override
    public void cargarImagen() { 
        int opcion = 0;
        do{ 
            System.out.println("\n### Manipulador de imágenes ###");
            System.out.println("Escoja su opción: ");
            System.out.println("1. Ejemplo imagen tipo bitmap");
            System.out.println("2. Ejemplo imagen tipo pixmap");
            System.out.println("3. Ejemplo imagen tipo hexmap");
            System.out.println("4. Imagen creada"); 
            System.out.println("5. Volver");
                
            try {
                System.out.println("Introduzca su eleccion: ");
                opcion = this.input.nextInt();
                switch (opcion) {
                    case 1: 
                            this.modificarImagenTipoBitmap(0);
                            break;
                    case 2: 
                            this.modificarImagenTipoPixmap(1);
                            break;
                    case 3: 
                            this.modificarImagenTipoHexmap(2);
                            break;
                    case 4:  
                            if(this.image.isBitmap()){
                                this.modificarImagenTipoBitmap(3);
                            }else if(this.image.isPixmap()){
                                this.modificarImagenTipoPixmap(3);
                            }else{
                                this.modificarImagenTipoHexmap(3);
                            }
                            break;
                    case 5: 
                            opcion = 5;
                            break;
                    default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;    
                    }
                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    this.input.next();
                }
            }while (opcion != 5); 
    }

    
    @Override
    public void crearImagenTipoBitmap() {
        System.out.println("\n### Manipulador de imágenes ###");
        
        System.out.println("Ingresar ancho: ");
        int width = input.nextInt();
        System.out.println("Ingresar largo:");
        int height = input.nextInt();
        List<Pixel> pixeles = new ArrayList<>();
        for(int i=0; i < (width*height); i++){
            int n = i +1;
            System.out.println("\npixbit "+n);
            System.out.println("Ingresar x: ");
            int x = input.nextInt();
            System.out.println("Ingresar y: ");
            int y = input.nextInt();
            System.out.println("Ingresar valor bit: ");
            int bit = input.nextInt();
            System.out.println("Ingresar profundidad: ");
            int depth = input.nextInt();
            Pixbit pixbit = new Pixbit(x,y,bit,depth);
            pixeles.add(pixbit);
        }
        Image imagen = new Image(width,height,pixeles);
        this.image = imagen;
        System.out.println("\n");
        System.out.println("Bitmap creado: \n");
        System.out.println(imagen.toString());
        
        System.out.println("\n\nIngresar cualquier valor para volver: ");
        input.next();
        
    }

    @Override
    public void crearImagenTipoPixmap() {
        System.out.println("\n### Manipulador de imágenes ###");
        
        System.out.println("Ingresar ancho: ");
        int width = input.nextInt();
        System.out.println("Ingresar largo:");
        int height = input.nextInt();
        List<Pixel> pixeles = new ArrayList<>();
        for(int i=0; i < (width*height); i++){
            int n = i +1;
            System.out.println("\npixrgb "+n);
            System.out.println("Ingresar x: ");
            int x = input.nextInt();
            System.out.println("Ingresar y: ");
            int y = input.nextInt();
            System.out.println("Ingresar valor R: ");
            int r = input.nextInt();
            System.out.println("Ingresar valor G: ");
            int g = input.nextInt();
            System.out.println("Ingresar valor B: ");
            int b = input.nextInt();
            System.out.println("Ingresar profundidad: ");
            int depth = input.nextInt();
            Pixrgb pixrgb = new Pixrgb(x,y,r,g,b,depth);
            pixeles.add(pixrgb);
        }
        Image imagen = new Image(width,height,pixeles); 
        this.image = imagen;
        System.out.println("\n");
        System.out.println("Pixmap creado: \n");
        
        System.out.println(imagen.toString());
        
        System.out.println("\n\nIngresar cualquier valor para volver: ");
        input.next();
    }

    @Override
    public void crearImagenTipoHexmap() {
        System.out.println("\n### Manipulador de imágenes ###");
        
        System.out.println("Ingresar ancho: ");
        int width = input.nextInt();
        System.out.println("Ingresar largo:");
        int height = input.nextInt();
        List<Pixel> pixeles = new ArrayList<>();
        for(int i=0; i < (width*height); i++){
            int n = i +1;
            System.out.println("\npixhex "+n);
            System.out.println("Ingresar x: ");
            int x = input.nextInt();
            System.out.println("Ingresar y: ");
            int y = input.nextInt();
            System.out.println("Ingresar valor hexadecimal (6 caracteres): ");
            String hex = input.nextLine();
            System.out.println("Ingresar profundidad: ");
            int depth = input.nextInt();
            Pixhex pixhex = new Pixhex(x,y,hex,depth);
            pixeles.add(pixhex);
        }
        Image imagen = new Image(width,height,pixeles); 
        this.image = imagen;
        System.out.println("\n");
        System.out.println("Hexmap creado: \n");
        System.out.println(imagen.toString());
        
        System.out.println("\n\nIngresar cualquier valor para volver: ");
        input.next();
    }

    
    @Override
    public void modificarImagenTipoBitmap(int index) { 
        
        if(index == 0){
            Pixel p1 = new Pixbit(0,0,1,4);
            Pixel p2 = new Pixbit(0,1,0,4);
            Pixel p3 = new Pixbit(1,0,1,3);
            Pixel p4 = new Pixbit(1,1,1,42);
            List<Pixel> pixelsBit = Arrays.asList(p1,p2,p3,p4);
            Image ima1 = new Image(2,2,pixelsBit);
            this.image = ima1;
        }
        
        Image img =  this.image;
        int opcion = 0;
        do{ 
            System.out.println("\n### Manipulador de imágenes ###");
            if(this.compressBoolean == true){
                System.out.println(this.cimage.toString());
            }else{
                System.out.println(this.image.toString());
            }
            System.out.println("Escoja su opción: ");
            System.out.println("1. Hacer FlipH");
            System.out.println("2. Hacer FlipV");
            System.out.println("3. Hacer Rotate90 hacia la derecha");
            System.out.println("4. Hacer ChangePixel"); 
            System.out.println("5. Hacer Crop"); 
            System.out.println("6. Invertir Bits"); 
            System.out.println("7. Comprimir imagen");
            System.out.println("8. Descomprimir imagen");
            System.out.println("9. Volver");
                
            try {
                System.out.println("Introduzca su eleccion: ");
                opcion = this.input.nextInt();
                switch (opcion) {
                    case 1:  
                            img.flipH();
                            this.setImage(img); 
                            break;

                    case 2:  
                            img.flipV();
                            this.setImage(img); 
                            break;
                    case 3:  
                            img.rotate90(); 
                            this.setImage(img); 
                            break;
                    case 4: 
                            System.out.println("\n Creando pixbit");
                            System.out.println("Ingresar x: ");
                            int x = input.nextInt();
                            System.out.println("Ingresar y: ");
                            int y = input.nextInt();
                            System.out.println("Ingresar valor bit: ");
                            int bit = input.nextInt();
                            System.out.println("Ingresar profundidad: ");
                            int depth = input.nextInt();
                            Pixbit pixbit = new Pixbit(x,y,bit,depth);
                            
                            img.changePixel(pixbit); 
                            this.setImage(img); 
                            break;
                    case 5: 
                            System.out.println("\n Ingresa coordenadas de corte");
                            System.out.println("Ingresar x1: ");
                            int x1 = input.nextInt();
                            System.out.println("Ingresar y2: ");
                            int y1 = input.nextInt();
                            System.out.println("Ingresar x2: ");
                            int x2 = input.nextInt();
                            System.out.println("Ingresar y2: ");
                            int y2 = y1;
                            
                            img.crop(x1, y1, x2, y2); 
                            this.setImage(img); 
                            break;
                    case 6: 
                            img.invertColorBit(); 
                            this.setImage(img); 
                            break;
                    case 7: 
                            CompressedImage cim = img.compress();
                            this.setCompressBoolean(true);
                            this.setCimage(cim);
                            break;
                    case 8: 
                            if(this.compressBoolean == true){
                                Image im = this.cimage.decompress();
                                this.setCompressBoolean(false);
                                this.setImage(im);
                            }else{
                                System.out.println("Imagen descomprimida ");
                            }
                            break;   
                    case 9: 
                            opcion = 9;
                            break;
                    default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;    
                    }

                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    this.input.next();
                }
            }while (opcion != 9);
        
    }

    @Override
    public void modificarImagenTipoPixmap(int index) {
        if(index == 1){
            Pixel p5 = new Pixrgb(0,0,22,22,22,2);
            Pixel p6 = new Pixrgb(0,1,2,34,43,2);
            Pixel p7 = new Pixrgb(1,0,222,12,2,5);
            Pixel p8 = new Pixrgb(1,1,222,12,2,5);
            List<Pixel> pixelsPix = Arrays.asList(p5,p6,p7,p8);
            Image imagen2 =  new Image(2,2,pixelsPix);
            this.image = imagen2;
        }
        Image img =  this.image;
        int opcion = 0;
        do{ 
            System.out.println("\n### Manipulador de imágenes ###");
            if(this.compressBoolean == true){
                System.out.println(this.cimage.toString());
            }else{
                System.out.println(this.image.toString());
            }
            System.out.println("Escoja su opción: ");
            System.out.println("1. Hacer FlipH");
            System.out.println("2. Hacer FlipV");
            System.out.println("3. Hacer Rotate90 hacia la derecha");
            System.out.println("4. Hacer ChangePixel"); 
            System.out.println("5. Hacer Crop"); 
            System.out.println("6. Invertir Rgb"); 
            System.out.println("7. Convertir a Hexadecimal"); 
            System.out.println("8. Comprimir imagen");
            System.out.println("9. Descomprimir imagen");
            System.out.println("10. Volver");
                
            try {
                System.out.println("Introduzca su eleccion: ");
                opcion = this.input.nextInt();
                switch (opcion) {
                    case 1: 
                            img.flipH();
                            this.setImage(img); 
                            break;

                    case 2: 
                            img.flipV();
                            this.setImage(img); 
                            break;
                    case 3: 
                            img.rotate90();
                            this.setImage(img); 
                            break; 
                    case 4:
                            System.out.println("\n Creando pixrgb");
                            System.out.println("Ingresar x: ");
                            int x = input.nextInt();
                            System.out.println("Ingresar y: ");
                            int y = input.nextInt();
                            System.out.println("Ingresar valor r: ");
                            int r = input.nextInt();
                            System.out.println("Ingresar valor g: ");
                            int g = input.nextInt();
                            System.out.println("Ingresar valor b: ");
                            int b = input.nextInt();
                            System.out.println("Ingresar profundidad: ");
                            int depth = input.nextInt();
                            Pixrgb pixrgb = new Pixrgb(x,y,r,g,b,depth);
                            
                            img.changePixel(pixrgb); 
                            this.setImage(img); 
                            break;
                    case 5: 
                            System.out.println("\n Ingresa coordenadas de corte");
                            System.out.println("Ingresar x1: ");
                            int x1 = input.nextInt();
                            System.out.println("Ingresar y2: ");
                            int y1 = input.nextInt();
                            System.out.println("Ingresar x2: ");
                            int x2 = input.nextInt();
                            System.out.println("Ingresar y2: ");
                            int y2 = y1;
                            
                            img.crop(x1, y1, x2, y2); 
                            this.setImage(img); 
                            break;
                    case 6: 
                            img.invertColorRGB();
                            this.setImage(img); 
                            break;
                    case 7: 
                            img.imgRGBToHex();
                            this.setImage(img); 
                            break;
                    case 8: 
                            CompressedImage cim = img.compress();
                            this.setCompressBoolean(true);
                            this.setCimage(cim); 
                            break;
                    case 9: 
                            if(this.compressBoolean == true){
                                Image im = this.cimage.decompress();
                                this.setCompressBoolean(false);
                                this.setImage(im);
                            }else{
                                System.out.println("Imagen descomprimida ");
                            }
                            break;
                            
                    case 10: 
                            opcion = 10;
                            break;
                    default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;    
                    }

                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    this.input.next();
                }
            }while (opcion != 10);
    }

    @Override
    public void modificarImagenTipoHexmap(int index) {
        if(index == 2){
            Pixel p9 = new Pixhex(0,0,"FFA412",2);
            Pixel p10 = new Pixhex(0,1,"A53BF1",2);
            Pixel p11 = new Pixhex(1,0,"FF5332",5);
            Pixel p12 = new Pixhex(1,1,"F452AB",5);
            List<Pixel> pixelsHex = Arrays.asList(p9,p10,p11,p12);
            Image imagen3 =  new Image(2,2,pixelsHex);
            this.image = imagen3;
        }
        Image img =  this.image;
        int opcion = 0;
        do{ 
            System.out.println("\n### Manipulador de imágenes ###");
            if(this.compressBoolean == true){
                System.out.println(this.cimage.toString());
            }else{
                System.out.println(this.image.toString());
            }
            System.out.println("Escoja su opción: ");
            System.out.println("1. Hacer FlipH");
            System.out.println("2. Hacer FlipV");
            System.out.println("3. Hacer Rotate90 hacia la derecha");
            System.out.println("4. Hacer ChangePixel"); 
            System.out.println("5. Hacer Crop"); 
            System.out.println("6. Comprimir imagen");
            System.out.println("7. Descomprimir imagen");
            System.out.println("8. Volver");
                
            try {
                System.out.println("Introduzca su eleccion: ");
                opcion = this.input.nextInt();
                switch (opcion) {
                    case 1: 
                            img.flipH();
                            this.setImage(img); 
                            break; 
                    case 2: 
                            img.flipV();
                            this.setImage(img); 
                            break;
                    case 3: 
                            img.rotate90();
                            this.setImage(img); 
                            break;
                    case 4: 
                            System.out.println("\n Creando pixhex");
                            System.out.println("Ingresar x: ");
                            int x = input.nextInt();
                            System.out.println("Ingresar y: ");
                            int y = input.nextInt();
                            System.out.println("Ingresar valor hexadecimal (6 caracteres): ");
                            String hex = input.nextLine();
                            System.out.println("Ingresar profundidad: ");
                            int depth = input.nextInt();
                            Pixhex pixhex = new Pixhex(x,y,hex,depth);
                            
                            img.changePixel(pixhex); 
                            this.setImage(img); 
                            break;
                    case 5: 
                            System.out.println("\n Ingresa coordenadas de corte");
                            System.out.println("Ingresar x1: ");
                            int x1 = input.nextInt();
                            System.out.println("Ingresar y2: ");
                            int y1 = input.nextInt();
                            System.out.println("Ingresar x2: ");
                            int x2 = input.nextInt();
                            System.out.println("Ingresar y2: ");
                            int y2 = y1;
                            
                            img.crop(x1, y1, x2, y2); 
                            this.setImage(img); 
                            break;
                    case 6: 
                            CompressedImage cim = img.compress();
                            this.setCompressBoolean(true);
                            this.setCimage(cim); 
                            break;
                    case 7: 
                            if(this.compressBoolean == true){
                                Image im = this.cimage.decompress();
                                this.setCompressBoolean(false);
                                this.setImage(im);
                            }else{
                                System.out.println("Imagen descomprimida ");
                            }
                            break;
                            
                    case 8: 
                            opcion = 8;
                            break;
                    default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;    
                    }

                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    this.input.next();
                }
            }while (opcion != 8);
    }


}

   
    
  



     