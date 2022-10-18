package Ejercicio5;

import java.util.Scanner;

public class PreguntaNombre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println("¿Como te llamas?");
        nombre = sc.nextLine();
        System.out.printf("¡Hola %s!", nombre);
    }
}
