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
public class Menu_19177246_CollaoCallpa implements IMenu_19177246_CollaoCallpa{
    
    Menu_19177246_CollaoCallpa menu;
    Scanner input = new Scanner(System.in);
    Image_19177246_CollaoCallpa image;
    Boolean compressBoolean = false;
    CompressedImage_19177246_CollaoCallpa cimage;

    public void setImage(Image_19177246_CollaoCallpa image) {
        this.image = image;
    }

    public void setCompressBoolean(Boolean compressBoolean) {
        this.compressBoolean = compressBoolean;
    }

    public void setCimage(CompressedImage_19177246_CollaoCallpa cimage) {
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
        List<Pixel_19177246_CollaoCallpa> pixeles = new ArrayList<>();
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
            Pixbit_19177246_CollaoCallpa pixbit = new Pixbit_19177246_CollaoCallpa(x,y,bit,depth);
            pixeles.add(pixbit);
        }
        Image_19177246_CollaoCallpa imagen = new Image_19177246_CollaoCallpa(width,height,pixeles);
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
        List<Pixel_19177246_CollaoCallpa> pixeles = new ArrayList<>();
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
            Pixrgb_19177246_CollaoCallpa pixrgb = new Pixrgb_19177246_CollaoCallpa(x,y,r,g,b,depth);
            pixeles.add(pixrgb);
        }
        Image_19177246_CollaoCallpa imagen = new Image_19177246_CollaoCallpa(width,height,pixeles); 
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
        List<Pixel_19177246_CollaoCallpa> pixeles = new ArrayList<>();
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
            Pixhex_19177246_CollaoCallpa pixhex = new Pixhex_19177246_CollaoCallpa(x,y,hex,depth);
            pixeles.add(pixhex);
        }
        Image_19177246_CollaoCallpa imagen = new Image_19177246_CollaoCallpa(width,height,pixeles); 
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
            Pixel_19177246_CollaoCallpa p1 = new Pixbit_19177246_CollaoCallpa(0,0,1,4);
            Pixel_19177246_CollaoCallpa p2 = new Pixbit_19177246_CollaoCallpa(0,1,0,4);
            Pixel_19177246_CollaoCallpa p3 = new Pixbit_19177246_CollaoCallpa(1,0,1,3);
            Pixel_19177246_CollaoCallpa p4 = new Pixbit_19177246_CollaoCallpa(1,1,1,42);
            List<Pixel_19177246_CollaoCallpa> pixelsBit = Arrays.asList(p1,p2,p3,p4);
            Image_19177246_CollaoCallpa ima1 = new Image_19177246_CollaoCallpa(2,2,pixelsBit);
            this.image = ima1;
        }
        
        Image_19177246_CollaoCallpa img =  this.image;
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
                            Pixbit_19177246_CollaoCallpa pixbit = new Pixbit_19177246_CollaoCallpa(x,y,bit,depth);
                            
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
                            CompressedImage_19177246_CollaoCallpa cim = img.compress();
                            this.setCompressBoolean(true);
                            this.setCimage(cim);
                            break;
                    case 8: 
                            if(this.compressBoolean == true){
                                Image_19177246_CollaoCallpa im = this.cimage.decompress();
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
            Pixel_19177246_CollaoCallpa p5 = new Pixrgb_19177246_CollaoCallpa(0,0,22,22,22,2);
            Pixel_19177246_CollaoCallpa p6 = new Pixrgb_19177246_CollaoCallpa(0,1,2,34,43,2);
            Pixel_19177246_CollaoCallpa p7 = new Pixrgb_19177246_CollaoCallpa(1,0,222,12,2,5);
            Pixel_19177246_CollaoCallpa p8 = new Pixrgb_19177246_CollaoCallpa(1,1,222,12,2,5);
            List<Pixel_19177246_CollaoCallpa> pixelsPix = Arrays.asList(p5,p6,p7,p8);
            Image_19177246_CollaoCallpa imagen2 =  new Image_19177246_CollaoCallpa(2,2,pixelsPix);
            this.image = imagen2;
        }
        Image_19177246_CollaoCallpa img =  this.image;
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
                            Pixrgb_19177246_CollaoCallpa pixrgb = new Pixrgb_19177246_CollaoCallpa(x,y,r,g,b,depth);
                            
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
                            CompressedImage_19177246_CollaoCallpa cim = img.compress();
                            this.setCompressBoolean(true);
                            this.setCimage(cim); 
                            break;
                    case 9: 
                            if(this.compressBoolean == true){
                                Image_19177246_CollaoCallpa im = this.cimage.decompress();
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
            Pixel_19177246_CollaoCallpa p9 = new Pixhex_19177246_CollaoCallpa(0,0,"FFA412",2);
            Pixel_19177246_CollaoCallpa p10 = new Pixhex_19177246_CollaoCallpa(0,1,"A53BF1",2);
            Pixel_19177246_CollaoCallpa p11 = new Pixhex_19177246_CollaoCallpa(1,0,"FF5332",5);
            Pixel_19177246_CollaoCallpa p12 = new Pixhex_19177246_CollaoCallpa(1,1,"F452AB",5);
            List<Pixel_19177246_CollaoCallpa> pixelsHex = Arrays.asList(p9,p10,p11,p12);
            Image_19177246_CollaoCallpa imagen3 =  new Image_19177246_CollaoCallpa(2,2,pixelsHex);
            this.image = imagen3;
        }
        Image_19177246_CollaoCallpa img =  this.image;
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
                            Pixhex_19177246_CollaoCallpa pixhex = new Pixhex_19177246_CollaoCallpa(x,y,hex,depth);
                            
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
                            CompressedImage_19177246_CollaoCallpa cim = img.compress();
                            this.setCompressBoolean(true);
                            this.setCimage(cim); 
                            break;
                    case 7: 
                            if(this.compressBoolean == true){
                                Image_19177246_CollaoCallpa im = this.cimage.decompress();
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

   
    
  



     