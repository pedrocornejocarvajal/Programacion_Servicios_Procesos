package Ejercicio3;

import java.io.File;
import java.io.IOException;

/**
 * Enunciado:
 *
 * Crea una clase Java que lance un proceso haciendo uso de la clase ProcessBuilder. En vez de tomar el comando por los
 * argumentos del main, debe solicitarle al usuario por consola que introduzca el comando/programa a ejecutar.
 */

public class Main {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java","ProcesoLento.java");
        //Establecer directorio de trabajo para poder ejecutar el proceso
        pb.directory(new File("src\\Ejercicio3"));


        try{
            Process p = pb.start(); //Lanzamos el proceso

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}