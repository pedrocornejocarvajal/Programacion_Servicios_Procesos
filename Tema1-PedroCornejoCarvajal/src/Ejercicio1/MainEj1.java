package Ejercicio1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Enunciado:
 *
 * Crea un programa que muestre un menú al usuario como el siguiente:
 * Elija qué comando desea ejecutar:
 *
 *      1. Crear carpeta
 *      2. Crear fichero
 *      3. Mostrar contenido del directorio
 *
 * Atendiendo a la opción seleccionada por el usuario, el programa debe lanzar un proceso u otro. Toma de base el archivo Ejercicio1.java que se adjunta a la tarea.
 */
public class MainEj1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc = menu();


        switch (opc) {
            // Si elige crear una carpeta, debo pedirle también la ruta donde quiere crearla
            // y el nombre de la carpeta
            case 1:
                String ruta;
                // Imprimimos el menú con las diversas opciones
                System.out.println("Indique la ruta de la carpeta con su nombre:");
                // Leemos la opción de teclado
                ruta = scanner.next();
                String[] comando1 = {"cmd","/C", "md", ruta};
                ProcessBuilder pb1 = new ProcessBuilder(comando1);
                pb1.inheritIO();
                try {
                    Process p1 =pb1.start();
                    p1.waitFor();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            // Si elige crear un fichero, debo pedirle también la ruta donde quiere crearlo
            // y el nombre del fichero
            case 2:
                break;
            // Si elige mostrar un directorio, debo pedirle también la ruta del directorio a
            // mostrar. Si lo deja vacío, debo mostrar el contenido del directorio actual
            case 3:
                break;
            default:
                System.out.println("La opción introducida no es correcta");
        }
    }

    public static int menu() {
        // En opc guardaremos la opción seleccionada por el usuario
        int opc;
        Scanner sc = new Scanner(System.in);

        // Imprimimos el menú con las diversas opciones
        System.out.println("Elija qué comando desea ejecutar:");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear fichero");
        System.out.println("3. Mostrar contenido del directorio");

        // Leemos la opción de teclado
        opc = sc.nextInt();
        sc.close();

        return opc;
    }
}