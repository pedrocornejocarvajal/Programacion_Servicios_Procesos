package ejercicio2;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej2Main {
    public static void main(String[] args) {

        //Creamos los procesos necesrios
        ProcessBuilder pb1 = new ProcessBuilder("java","src/ejercicio2/MayoresEdad.java");
        ProcessBuilder pb2 = new ProcessBuilder("java","src/ejercicio2/OrdenaNombres.java");

        //Indicamos a los procesos cual es la entrada
        pb1.redirectInput(new File("src/Ejercicio2/alumnos.txt"));
        pb2.redirectInput(new File("src/Ejercicio2/alumnos.txt"));

        //Redireccionamos los errores
        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);
        try{

            //Ejecutamos los procesos
           pb1.start();
            pb2.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
