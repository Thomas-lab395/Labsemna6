/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labsemana6;
  import java.util.ArrayList;
import java.util.Scanner;

public class Labsemana6 {
    private static ArrayList<String> palabras = new ArrayList<>();
    private static final int MAX_OPORTUNIDADES = 5;

    public static void main(String[] args) {
       
        palabras.add("HONDURAS");
        palabras.add("JAVA");
        palabras.add("PROGRAMACION");
        palabras.add("COMPUTADORA");
        palabras.add("TECLADO");
        palabras.add("MONITOR");
        palabras.add("MOUSE");
        palabras.add("CELULAR");
        palabras.add("INTERNET");
        palabras.add("TECNOLOGIA");
        
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Jugar");
            System.out.println("2. Cambiar Palabras");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            if (opcion == 1) {
                
                String palabraSeleccionada = palabras.get((int) (Math.random() * palabras.size()));
                char[] palabraOculta = new char[palabraSeleccionada.length()];
                for (int i = 0; i < palabraOculta.length; i++) {
                    palabraOculta[i] = '_';
                }
                
                int oportunidades = MAX_OPORTUNIDADES;
                boolean palabraAdivinada = false;
                
                while (oportunidades > 0 && !palabraAdivinada) {
                    System.out.print("\nPalabra: ");
                    for (char c : palabraOculta) {
                        System.out.print(c + " ");
                    }
                    
                    System.out.println("\nOportunidades restantes: " + oportunidades);
                    System.out.print("Ingrese un caracter: ");
                    char intento = scanner.nextLine().toUpperCase().charAt(0);
                    
                    boolean acierto = false;
                    for (int i = 0; i < palabraSeleccionada.length(); i++) {
                        if (palabraSeleccionada.charAt(i) == intento && palabraOculta[i] == '_') {
                            palabraOculta[i] = intento;
                            acierto = true;
                        }
                    }
                    
                    if (acierto) {
                        System.out.println("Le pegaste a un caracter!");
                    } else {
                        System.out.println("La palabra no contiene ese caracter.");
                        oportunidades--;
                    }
                    
                    palabraAdivinada = true;
                    for (char c : palabraOculta) {
                        if (c == '_') {
                            palabraAdivinada = false;
                            break;
                        }
                    }
                }
                
                if (palabraAdivinada) {
                    System.out.println("\nFelicidades Adivinaste la palabra: " + palabraSeleccionada);
                } else {
                    System.out.println("\nLo siento, te quedaste sin oportunidades. La palabra era: " + palabraSeleccionada);
                }
            } else if (opcion == 2) {
                
                System.out.println("\nLista actual de palabras:");
                for (int i = 0; i < palabras.size(); i++) {
                    System.out.println((i + 1) + ". " + palabras.get(i));
                }
                
                System.out.println("\nIngrese 10 nuevas palabras separadas por enter:");
                String nuevasPalabras = scanner.nextLine().toUpperCase();
                String[] palabrasArray = nuevasPalabras.split(" ");
                
                if (palabrasArray.length == 10) {
                    palabras.clear();
                    for (String palabra : palabrasArray) {
                        palabras.add(palabra);
                    }
                    System.out.println("Las palabras se han actualizado correctamente.");
                } else {
                    System.out.println("Debe ingresar exactamente 10 palabras.");
                }
            } else if (opcion == 3) {
                salir = true;
                System.out.println("Gracias por jugar, Hasta luego.");
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }
}
