/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author delacoll
 */
public class Ui implements IUi{
    
    Ui menu;
    
    /*
    *   Inicializa el menu principal
    */
    @Override
    public void iniciar() {
        Scanner input = new Scanner(System.in);
        int opcion; 
        boolean salir; 
        salir = false; 
        do{ 
            System.out.println("### DOBBLE ###");
            System.out.println("Escoja su opcion: ");
            System.out.println("1. 1 vs 1");
            System.out.println("2. CPU vs CPU");
            System.out.println("3. 1 vs CPU");
            System.out.println("4. Salir");
                
            try {
                System.out.println("Introduzca su eleccion: ");
                opcion = input.nextInt();
                switch (opcion) {
                    case 1: 
                            System.out.println("### ESCOJE UN NUMERO PRIMO ###");
                            System.out.println("Ejemplos: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59");
                            System.out.println("Si elijes 3, todas las cartas tendran 4 simbolos, mientras mas mayor, más se eleva la dificultad.");
                            Scanner inputw = new Scanner(System.in);
                            int opcion2 = inputw.nextInt();
                            // unoContraUno(opcion2, 1);
                            break;

                    case 2: 
                            System.out.println("### ESCOJE UN NUMERO PRIMO ###");
                            System.out.println("Ejemplos: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59");
                            System.out.println("Si elijes 3, todas las cartas tendran 4 simbolos, mientras mas mayor, más se eleva la dificultad.");
                            Scanner inputw3 = new Scanner(System.in);
                            int opcion3 = inputw3.nextInt();
                            // unoContraUno(opcion3, 2);
                            break;
                    case 3: 
                            System.out.println("### ESCOJE UN NUMERO PRIMO ###");
                            System.out.println("Ejemplos: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59");
                            System.out.println("Si elijes 3, todas las cartas tendran 4 simbolos, mientras mas mayor, más se eleva la dificultad.");
                            Scanner inputw4 = new Scanner(System.in);
                            int opcion4 = inputw4.nextInt();
                            // unoContraUno(opcion4, 3);
                            break;
                    case 4: 
                            salir = true;
                            input.close();
                            break; 
    
                    default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;    
                    }

            } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    input.next();
            }
        }while (salir = true);
    }
    
}
