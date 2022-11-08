package ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej3Main {
    public static void main(String[] args) {

        //Creamos los procesos para ejecutar las clases
        ProcessBuilder pb1 = new ProcessBuilder("java","src/ejercicio3/NumerosAleatorios.java");
        ProcessBuilder pb2 = new ProcessBuilder("java","src/ejercicio3/SumaNumeros.java");
        ProcessBuilder pb3 = new ProcessBuilder("java","src/ejercicio3/MediaNumeros.java");
        //Salida por fichero


        List<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();
        lpb.add(pb1);
        lpb.add(pb2);
        lpb.add(pb3);

        //Redirigimos los errores para controlarlos
        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb3.redirectError(ProcessBuilder.Redirect.INHERIT);
        try{
            //Generamos los archivos
            for (int i = 0; i <10 ; i++) {
                pb1.redirectOutput(new File("src/Ejercicio3/Ficheros/numeroAleatorio" +i +".txt")); //Indicamos la salida de nuestro proceso de numeros aleatorios
                pb2.redirectInput(new File("src/Ejercicio3/Ficheros/numeroAleatorio" +i +".txt")); //Indicamos la entrada de nuestro proceso de suma
                pb3.redirectInput(new File("src/Ejercicio3/Ficheros/numeroAleatorio" +i +".txt")); //Indicamos la entrada de nuestro proceso de medias
                pb2.redirectOutput(new File("src/Ejercicio3/Ficheros/SumaNumeros" +i +".txt")); //Indicamos la salida de nuestro proceso de Sumar los numeros
                pb3.redirectOutput(new File("src/Ejercicio3/Ficheros/MediaNumeros" +i +".txt")); //Indicamos la salida de nuestro proceso de hacer las medias
//                List<Process> lProcess = ProcessBuilder.startPipeline(lpb);
// TODO AÑADIR EL NOMBRE DEL FICHERO CON ProcessBuilder.Redirect.appendTo
                //Ejecutamos los procesos
                pb1.start();
                pb2.start();
                pb3.start();


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }

