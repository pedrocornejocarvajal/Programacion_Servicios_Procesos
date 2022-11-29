package Ejercicio10;

import java.io.IOException;

/**
 * Enunciado:
 *
 * Crea una clase que lance los siguientes procesos y que sincronice la ejecución entre ellos:
 *
 *      - Proceso 1: Creación por línea de comandos de una carpeta de nombre “carpeta1” en la ruta C:\pruebas.
 *        Si esta carpeta no existe créala. Para crearla en esta ruta tendrás que cambiar el directorio de trabajo del Proceso 1.
 *
 *      - Proceso 2: Creación por línea de comandos un fichero en blanco en la carpeta creada en el Proceso 1. Llama al
 *        fichero “fichero1.txt”. Para ello, cambia el directorio de trabajo del Proceso 2 para que apunte a esta carpeta.
 *        Deberá esperar a que termine correctamente el Proceso 1 antes de crear el fichero.
 *
 *      - Proceso 3: Abre el fichero creado en el Proceso 2 con el bloc de notas (el comando es notepad).
 *        Establece el directorio de trabajo del Proceso 3 para abrir este fichero. Antes de abrir el fichero tiene que esperar a que termine el Proceso 2.
 */

public class Main {
    public static void main(String[] args) {

        String[] comando1 = {"cmd","/C", "md", "C:\\Users\\pcornejo\\Documents\\EjercicioSegundo\\Programacion_Servicios_Procesos\\EjerciciosUnidad1\\src\\Ejercicio10\\carpeta1"};
        String[] comando2 = {"cmd","/C", "type", "nul",">", "C:\\Users\\pcornejo\\Documents\\EjercicioSegundo\\Programacion_Servicios_Procesos\\EjerciciosUnidad1\\src\\Ejercicio10\\fichero1.txt"};
        String[] comando3 = { "notepad", "C:\\Users\\pcornejo\\Documents\\EjercicioSegundo\\Programacion_Servicios_Procesos\\EjerciciosUnidad1\\src\\Ejercicio10\\fichero1.txt"};

        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        ProcessBuilder pb3 = new ProcessBuilder(comando3);

        pb1.inheritIO();
        pb2.inheritIO();
        pb3.inheritIO();

        try {
            Process p1 =pb1.start();
            p1.waitFor();
            Process p2 =pb2.start();
            p2.waitFor();
            Process p3 =pb3.start();
            p3.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
