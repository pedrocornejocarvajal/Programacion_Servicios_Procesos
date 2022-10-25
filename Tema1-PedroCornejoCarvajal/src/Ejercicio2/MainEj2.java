package Ejercicio2;

/**
 * Enunciado:
 *
 * Crea una clase que lance los siguientes procesos y que sincronice la ejecución entre ellos:ç
 *
 *      - Proceso 1: Debe abrir la aplicación bloc de notas. El usuario debe escribir en él una serie de líneas. Cuando termine de escribir,
 *        guardará el fichero y cerrará el bloc de notas. El fichero a guardar debe llamarse numLineas.txt y guardarse en la carpeta C:\ejercicio2.
 *
 *      - Proceso 2: Debe lanzar una clase Java que se llamará CuentaLineas.java.
 *        La clase CuentaLineas.java debe leer de la entrada estándar una serie de líneas (no sabemos cuántas) y devolver el número de líneas que ha leído.
 *        El proceso 2 debe redireccionar la entrada estándar de forma que ésta sea el fichero numLineas.txt creado por el Proceso 1. La salida estándar
 *        y la de error del Proceso 2 deben redirigirse hacia las del proceso padre (es decir, la consola).
 *        El Proceso 2 debe esperar a que el Proceso 1 termine para así poder leer del fichero, pero si el Proceso 1 tarda más de 30 segundos en terminar,
 *        se debe de terminar la ejecución del proceso, mostrando el mensaje de error correspondiente.
 */

public class MainEj2 {
    public static void main(String[] args) {

    }
}
