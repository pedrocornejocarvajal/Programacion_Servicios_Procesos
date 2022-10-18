package Ejercicio4;

import java.io.File;
import java.io.IOException;

public class EJ4 {
    /**
     * Partiendo del ejercicio 2, modifícalo para redireccionar la salida estándar del
     * proceso a un fichero de texto llamado salidaProcesoLento.txt.
     */
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("Java","ProcesoLento.java");
        File directorio = new File("src\\Ejercicio4");
        pb.directory(directorio);
        pb.redirectOutput(new File("src\\Ejercicio4\\salidaProcesoLento.txt"));
        try{
            Process p = pb.start();
            do {
                Thread.sleep(3000);
                System.out.println(p.isAlive()?"Esta vivo":"No esta vivo");
            }while(p.isAlive());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
