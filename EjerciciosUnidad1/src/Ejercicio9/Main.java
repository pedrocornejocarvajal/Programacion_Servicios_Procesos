package Ejercicio9;

import java.io.*;

/**
 * Enunciado:
 *
 * Realiza de nuevo el ejercicio 5, pero en vez de utilizar ProcessBuilder para lanzar la clase PreguntaNombre.java
 * utiliza la clase Runtime. Utiliza el método getOutputStream() de la clase Process para que tome los datos de un
 * fichero de texto, por ejemplo, entradaNombre.txt. Para poder ver la salida en la consola habrá que usar el método getInputStream() e imprimirlo por pantalla.
 */


public class Main {
    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();
        String[] comando = {"java", "src\\Ejercicio9\\PreguntaNombre.java"};

        try {
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Ejercicio9\\entradaNombre.txt"));


            String line = br.readLine();
            while(line!=null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
            bw.close();
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
