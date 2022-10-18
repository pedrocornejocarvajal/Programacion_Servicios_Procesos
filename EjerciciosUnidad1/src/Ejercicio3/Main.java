package Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Enunciado:
 *
 * Crea una clase Java que lance un proceso haciendo uso de la clase ProcessBuilder. En vez de tomar el comando por los
 * argumentos del main, debe solicitarle al usuario por consola que introduzca el comando/programa a ejecutar.
 */

public class Main {
    public static void main(String[] args) {
            String comando;
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce un comando: ");
            comando = sc.nextLine();
            ejecutarProceso(comando);
        }

        private static void ejecutarProceso(String comando){
            String[] comandoAEjecutar = comando.split(" ");
            ProcessBuilder pb = new ProcessBuilder(comandoAEjecutar);
            pb.inheritIO();
            try {
                Process p = pb.start();
                p.waitFor();
                System.out.println("Proceso finalizado");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
