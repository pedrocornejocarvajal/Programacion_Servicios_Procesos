package Ejercicio11;

import java.io.IOException;

/**
 *Enunciado:
 *
 *Crea una clase que lance los siguientes procesos y que sincronice la ejecución entre ellos:
 *
 *      - Proceso 1: Creación por línea de comandos un fichero en blanco en la carpeta “carpeta1” que se creó en el ejercicio anterior.
 *        Llama al fichero “fichero2.txt”. Para ello, cambia el directorio de trabajo del Proceso 1 para que apunte a esta carpeta.
 *
 *      - Proceso 2: Abre el fichero creado en el Proceso 1 con el bloc de notas (el comando es notepad). Establece el directorio
 *        de trabajo del Proceso 2 para abrir este fichero. Antes de abrir el fichero tiene que esperar a que termine el Proceso 1.
 *
 *      - Proceso 3: Debe lanzar una clase Java que se encargue de leer el contenido del fichero “fichero2.txt” y mostrar el contenido
 *        del fichero por pantalla. Antes de lanzar esta clase Java debe esperar a que termine de ejecutarse el Proceso 2.
 *
 * Cuando pongas en ejecución esta clase, en el momento en el que se abra el bloc de notas debes escribir un mensaje, que será el que
 * se muestre cuando se lance el Proceso 3. Hasta que no cierres el bloc de notas no va a ejecutarse el Proceso 3.
 */

public class Main {
    public static void main(String[] args) {

        String[] comando1 = {"cmd","/C", "type", "nul",">", "C:\\Users\\pcornejo\\Documents\\EjercicioSegundo\\Programacion_Servicios_Procesos\\EjerciciosUnidad1\\src\\Ejercicio10\\carpeta1\\fichero2.txt"};
        String[] comando2 = { "notepad", "C:\\Users\\pcornejo\\Documents\\EjercicioSegundo\\Programacion_Servicios_Procesos\\EjerciciosUnidad1\\src\\Ejercicio10\\carpeta1\\fichero2.txt"};
        String[] comando3 = {"java", "C:\\Users\\pcornejo\\Documents\\EjercicioSegundo\\Programacion_Servicios_Procesos\\EjerciciosUnidad1\\src\\Ejercicio11\\leerFichero.java"};

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