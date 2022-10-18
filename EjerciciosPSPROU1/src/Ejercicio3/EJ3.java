package Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/***
 * Crea una clase Java que lance un proceso haciendo uso de la clase ProcessBuilder.
 * En vez de tomar el comando por los argumentos del main, debe solicitarle al usuario
 * por consola que introduzca el comando/programa a ejecutar.
 */
public class EJ3 {
    public static void main(String[] args) {
        String comando;
        Scanner sc = new Scanner(System.in);
        System.out.print("Indicame un comando o programa a ejecutar: ");
        comando = sc.nextLine();
        ejecutarProceso(comando);// Ejemplo: cmd /C dir C: y java src/Miau.java
    }

    private static void ejecutarProceso(String comando){
        String[] comandoArray = comando.split(" ");
        ProcessBuilder pb = new ProcessBuilder(comandoArray);
        pb.inheritIO();
        try {
            Process p = pb.start();
            p.waitFor();
            System.out.println("Proceso terminado");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
