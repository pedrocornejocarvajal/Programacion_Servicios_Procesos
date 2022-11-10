package ejercicio1;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ej1Main {
    public static void main(String[] args) {

        String comando = "java src/ejercicio1/Calculadora.java";
        int[] opciones = new int[3];


        switch (menu()) {

            case 1 -> {
                opciones[0] = 1;
                generarArgumentos(comando, opciones);
            }

            case 2 -> {
                opciones[0] = 2;
                generarArgumentos(comando, opciones);
            }
            case 3 -> {
                opciones[0] = 3;
                generarArgumentos(comando, opciones);
            }
            case 4 -> {
                opciones[0] = 4;
                generarArgumentos(comando, opciones);
            }
        }


    }

    /**
     * Metodo para generar los argumentos a pasar mas el comando completo
     * @param comando
     * @param opciones
     */
    private static void generarArgumentos(String comando, int[] opciones) {
        int[] numeros;
        numeros = pedirNumeros();
        opciones[1] = numeros[0];
        opciones[2] = numeros[1];
        ProcessBuilder pb = new ProcessBuilder((comando + " " + Arrays.toString(opciones)));
        pb.inheritIO();
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Meotdo para pedir los numeros por pantalla y recogerlos
     * @return
     */
    private static int[] pedirNumeros() {
        Scanner sc = new Scanner(System.in);
        int[] opciones = new int[2];
        System.out.println("Introduce el primer numero");
        opciones[0]=sc.nextInt();
        System.out.println("Introduce el segundo numero");
        opciones[1]=sc.nextInt();
        return opciones;

    }

    /**
     * Metodo para mostrar el menu principal
     *
     * @return La opción seleccionada por el usuario
     */
    public static int menu() {
        // En opc guardaremos la opción seleccionada por el usuario
        int opc;
        Scanner sc = new Scanner(System.in);

        // Imprimimos el menú con las diversas opciones
        System.out.println("Elija la operacion a realizar:");
        System.out.println("1. SUMA");
        System.out.println("2. RESTA");
        System.out.println("3. MULTIPLICACIÓN");
        System.out.println("3. DIVISIÓN");

        // Leemos la opción de teclado y la devolvemos
        opc = sc.nextInt();

        return opc;
    }
}
