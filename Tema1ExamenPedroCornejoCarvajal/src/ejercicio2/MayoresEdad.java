package ejercicio2;

import java.util.Scanner;

/**
 * Esta clase se encarga de leer una serie de líneas de la entrada estándar,
 * formadas por nombres de alumnos y su edad. Debe imprimir por salida estándar
 * únicamente aquellos que sean mayores de edad.
 */
public class MayoresEdad {

    public static void main(String[] args) {
        // Línea que contendrá los datos de un línea.
        // La voy a ir leyendo de la entrada estándar
        String linea;

        // Creo el Scanner para leer de la entrada estándar
        Scanner sc = new Scanner(System.in);

        // Mientras haya líneas que leer seguiremos leyendo
        //Posteriormente recogemos la linea a leer y separamos de ella la edad indicandole que se separa por ;
        //Finalmente comprobamos que la edad sea mayor o igual que 17 y la pintamos por pantalla
        while (sc.hasNextLine()) {
            linea = sc.nextLine();
            String[] mayordeEdad;
            int edad;
            mayordeEdad = linea.split(";");
            edad = Integer.parseInt(mayordeEdad[0]);
            if (edad >= 18) {
                System.out.println(linea);
            }
        }
        sc.close();
    }

}
