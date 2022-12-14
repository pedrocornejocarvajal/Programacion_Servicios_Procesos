package Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;


/** * Enunciado:
 *
 * Crea un programa que cuente las vocales de un fichero de texto que se adjunta a la tarea (fichero_texto.txt).
 * Para ello crea una clase que lance la clase CuentaCaracteres.java (se adjunta a la tarea) 5 veces en paralelo,
 * una por cada vocal. La clase CuentaCaracteres.java lee el carácter a contar por la línea de argumentos,
 * por lo que habrá indicarle el carácter a buscar en el momento de construir el proceso. La salida de todos los
 * procesos debe ser la salida estándar, la heredada por el padre.
 *
 * Realiza dos ejecuciones, una en la que cada proceso espere al anterior y otra en la que los procesos no se esperen entre sí.
 * Cuenta la cantidad de milisegundos que transcurren entre los dos casos. ¿Hay alguna diferencia? Pon cada solución en dos clases distintas.
 */

public class MainEj3 {

    public static void main(String[] args) {
        // Empiezo a contar
        long inicio = System.currentTimeMillis();

        // Array donde almacenamos las vocales
        String[] vocales = { "a", "e", "i", "o", "u" };

        // Comando que ejecuta la clase CuentaCaracteres
        String comando = "java ejercicio3.CuentaCaracteres";

        // Creo una lista donde voy a guardar todos los procesos que se lancen
        List<Process> listaProcesos = new ArrayList<Process>();

        try {
            // Hacemos un bucle que recorra las vocales
            for (int i = 0; i < vocales.length; i++) {
                // Añadimos la vocal al final del comando
                ProcessBuilder pb = new ProcessBuilder((comando + " " + vocales[i]).split(" "));
                pb.directory(new File("bin"));
                pb.inheritIO();
                Process p = pb.start();
                listaProcesos.add(p);
            }

            int procesosVivos = 5;
            // Mientras haya algún proceso vivo vuelvo a comenzar la cuenta
            while (procesosVivos > 0) {
                procesosVivos = 5;
                // Recorro la lista de procesos para ver si siguen vivos
                for (Process proceso : listaProcesos) {
                    // Si alguno de los procesos ya ha terminado, entonces resto 1 a procesosVivos
                    if(!proceso.isAlive()) {
                        procesosVivos--;
                    }
                }
            }

            // Una vez que sé que todos los procesos han terminado, entonces miro el código con el que han terminado
            for(Process proceso : listaProcesos) {
                int retorno = proceso.exitValue();

                // Compruebo cómo ha terminado el proceso y escribo un mensaje en consecuencia
                if (retorno == 0) {
                    System.out.println("El proceso ha finalizado correctamente");
                } else {
                    System.out.println(
                            "El proceso ha terminado con el siguiente código de error: " + retorno);
                }
            }
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            // Indicamos que la ejecución termina con error 1
            System.exit(1);
        }

        long fin = System.currentTimeMillis();
        System.out.println("Ha tardado en ejecutarse: " + (fin-inicio) + " milisegundos.");
    }

}
