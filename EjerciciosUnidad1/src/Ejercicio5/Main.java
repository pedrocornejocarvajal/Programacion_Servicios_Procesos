package Ejercicio5;

import java.io.File;
import java.io.IOException;

/**
 * Enunciado:
 *
 * Crea una clase Java llamada PreguntaNombre.java. Esta clase debe preguntarle al usuario su nombre, el cual debe
 * introducirlo por la entrada estándar, e imprimir en la salida estándar “¡Hola nombre!”, donde nombre es el nombre
 * introducido por teclado. Crea otra clase que se encargue de lanzar PreguntaNombre.java como un proceso. Además,
 * redirecciona la entrada estándar para que se lea desde un fichero. La salida del proceso debe ser la estándar,
 * es decir, la pantalla.
 */

public class Main {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("Java","PreguntaNombre.java");
        File directorio = new File("src\\Ejercicio5");
        pb.directory(directorio);
        pb.redirectInput(new File("src\\Ejercicio5\\fichero.txt"));
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try{
            Process p = pb.start();
            System.out.println("Proceso terminado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
