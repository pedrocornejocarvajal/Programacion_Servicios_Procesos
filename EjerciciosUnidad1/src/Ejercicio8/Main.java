package Ejercicio8;

import java.io.*;

/**
 * Enunciado:
 *
 * Al igual que se hizo en el ejercicio 4, crea una clase que lance el proceso ProcesoLento.Java pero usando la clase
 * Runtime en vez de la clase ProcessBuilder. En este ejercicio vamos a tomar la salida del proceso con el método
 * getInputStream() de la clase Process, y la vamos a leer para luego escribirla en un fichero llamado salidaProcesoLento2.txt.
 */
public class Main {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String[] comando = {"java", "src\\Ejercicio8\\ProcesoLento.java"};

        try {
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Ejercicio8\\salidaProcesoLento2txt"));

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
