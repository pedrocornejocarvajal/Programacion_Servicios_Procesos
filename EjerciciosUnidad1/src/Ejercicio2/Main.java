package Ejercicio2;

import java.io.File;
import java.io.IOException;

/**
 * Enunciado:
 *
 * Crea un programa que lance la clase Ejercicio2.ProcesoLento.Java (para ello, mete en el mismo paquete la clase Ejercicio2.ProcesoLento.
 * java y la clase que vayas a crear). Utiliza el método isAlive() de la clase Process para comprobar si la clase
 * Ejercicio2.ProcesoLento se sigue ejecutando e imprimir un mensaje indicando que el proceso sigue en ejecución. Esta comprobación
 * debe hacerla cada 3 segundos mientras esté en ejecución. Cuando ya no esté en ejecución debe terminar, para lo cual
 * utiliza Thread.sleep(int tiempo_ms).
 */

public class Main {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("java", "ProcesoLento.java");
        //Establecer directorio de trabajo para poder ejecutar el proceso
        pb.directory(new File("src\\Ejercicio2"));
        System.out.println("Voy a lanzar un proceso");
        pb.inheritIO(); //Es para ver el proceso que he lanzado
        try {
            Process p = pb.start(); //Lanzamos el proceso
            do {
                Thread.sleep(3000);
                System.out.println(p.isAlive());
            } while (p.isAlive());
        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }

