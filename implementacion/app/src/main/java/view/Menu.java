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
 * @author delacoll
 */
public class Menu implements IMenu{
    
    Menu menu;
    Scanner input = new Scanner(System.in); 
    List<Image> imagenes = new ArrayList<>();
    
    /* Inicializa el menu principal */
    @Override
    public void iniciar() {
        this.ejemplos();
        int opcion = 0;
        do{ 
            System.out.println("### Manipulador de imágenes ###");
            System.out.println("Escoja su opción: ");
            System.out.println("1. Nueva imagen");
            System.out.println("2. Modificar una imagen");
            System.out.println("3. Visualizar imagen"); 
            System.out.println("4. Salir");
                
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
                            this.cargarImagen();
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
    public void crearNuevaImagen() { 
        int opcion = 0;
        do{ 
            System.out.println("### Manipulador de imágenes ###");
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
    
    public void ejemplos(){
        Pixel p1 = new Pixbit(0,0,1,4);
        Pixel p2 = new Pixbit(0,1,0,4);
        Pixel p3 = new Pixbit(1,0,1,3);
        Pixel p4 = new Pixbit(1,1,1,42);
        
        Pixel p5 = new Pixrgb(0,0,22,22,22,2);
        Pixel p6 = new Pixrgb(0,1,2,34,43,2);
        Pixel p7 = new Pixrgb(1,0,222,12,2,5);
        Pixel p8 = new Pixrgb(1,1,222,12,2,5);
        
        Pixel p9 = new Pixhex(0,0,"FFA412",2);
        Pixel p10 = new Pixhex(0,1,"A53BF1",2);
        Pixel p11 = new Pixhex(1,0,"FF5332",5);
        Pixel p12 = new Pixhex(1,1,"F452AB",5);
        
        Pixel p13 = new Pixhex(1,1,"F452AB",145);
        Pixel p14 = new Pixrgb(1,1,142,142,145,145);
        Pixel p15 = new Pixbit(1,1,1,145);
        
        List<Pixel> pixelsBit = Arrays.asList(p1,p2,p3,p4);
        List<Pixel> pixelsPix = Arrays.asList(p5,p6,p7,p8);
        List<Pixel> pixelsHex = Arrays.asList(p9,p10,p11,p12);

        // instanciacion de una imagen
        
        Image imagen1 = new Image(2,2,pixelsBit);
        Image imagen2 =  new Image(2,2,pixelsPix);
        Image imagen3 =  new Image(2,2,pixelsHex);
         
        this.imagenes.add(imagen1);
        this.imagenes.add(imagen2); 
        this.imagenes.add(imagen3);
        this.imagenes.add(imagen1);

    }
    
 
    @Override
    public void cargarImagen() { 
        int opcion = 0;
        do{ 
            System.out.println("### Manipulador de imágenes ###");
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
                            if(this.imagenes.get(3).isBitmap()){
                                this.modificarImagenTipoBitmap(3);
                            }else if(this.imagenes.get(3).isPixmap()){
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
        System.out.println("### Manipulador de imágenes ###");
        
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
        this.imagenes.add(3, imagen);
        System.out.println("\n");
        System.out.println("Bitmap creado: \n");
        System.out.println(imagen.toString());
        
        System.out.println("\n\nIngresar cualquier valor para volver: ");
        input.next();
        
    }

    @Override
    public void crearImagenTipoPixmap() {
        System.out.println("### Manipulador de imágenes ###");
        
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
        this.imagenes.add(3, imagen);
        System.out.println("\n");
        System.out.println("Pixmap creado: \n");
        
        System.out.println(imagen.toString());
        
        System.out.println("\n\nIngresar cualquier valor para volver: ");
        input.next();
    }

    @Override
    public void crearImagenTipoHexmap() {
        System.out.println("### Manipulador de imágenes ###");
        
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
        this.imagenes.add(3, imagen);
        System.out.println("\n");
        System.out.println("Hexmap creado: \n");
        System.out.println(imagen.toString());
        
        System.out.println("\n\nIngresar cualquier valor para volver: ");
        input.next();
    }

    

    @Override
    public void modificarImagenTipoBitmap(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarImagenTipoPixmap(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarImagenTipoHexmap(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}

   
    
  



     