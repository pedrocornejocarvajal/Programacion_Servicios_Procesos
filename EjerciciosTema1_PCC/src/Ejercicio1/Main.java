package Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Enunciado:
 *
 * Muestra el entorno de ejecución de un proceso con Map<String, String> environment() de ProcessBuilder. Hay que iterar
 * sobre el Map<String, String> devuelto para mostrar cada entrada.
 */

public class Main {
    public static void main(String[] args) {

            ProcessBuilder pb = new ProcessBuilder("java","ProcesoLento.java");
            //Establecer directorio de trabajo para poder ejecutar el proceso
            pb.directory(new File("src\\Ejercicio1"));
            System.out.println("Voy a lanzar un proceso");
            pb.inheritIO(); //Es para ver el proceso que he lanzado

            //Solucion EJ1 bien -> Errores: uso del MAP
            Map<String, String> mapa = pb.environment(); //Un mapa es una lista de clave valor donde no hay repeticiones y el valor 1 esta casado a clave 1
            //environment es el entorno de ejecucion
            Set<String> claves = mapa.keySet(); //me devuelve la clave
            System.out.println("Miramos el entorno de proceso");
            for (String clave: claves) { //Solo recorro las claves
                String valor = mapa.get(clave); // Devuelve el valor de dicha clave
                System.out.println("[ "+clave+": "+valor+" ]"); //Se imprime por pantalla
            }
            System.out.println("Voy a lanzar un proceso");
            try{
                Process p = pb.start(); //Lanzamos el proceso

            } catch (IOException e){
                e.printStackTrace();
            }
    }
}
