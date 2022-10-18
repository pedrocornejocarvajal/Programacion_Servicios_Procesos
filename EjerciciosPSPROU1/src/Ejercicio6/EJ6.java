package Ejercicio6;

import java.io.File;
import java.io.IOException;

public class EJ6 {
    /**
     * Crea una clase Java llamada TicketCompra.java. Esta clase debe pedirle al usuario los siguientes datos:
     * Código del producto: debe ser un número entero que represente el código del producto.
     * Precio del producto: debe ser un número decimal que represente el precio del producto.
     * Cantidad: debe ser un número entero que indique el número de unidades que se han comprado de ese producto.
     * (No imprimir mensaje en la salida estándar para que pida los distintos datos).
     * En la salida estándar debe imprimirse los datos introducidos por el usuario de la siguiente manera:
     * Código - Precio - Cantidad - Total
     * Donde Total es un valor calculado a partir del Precio y la Cantidad.
     * Crea otra clase que se encargue de lanzar TicketCompra.java como un proceso. Además, redirecciona la salida
     * estándar para que escriba la salida estándar en un fichero. Cada vez que escriba en el fichero debe concatenar
     * el nuevo contenido, no sobreescribir el anterior. La entrada del proceso debe ser la estándar, es decir, el teclado.
     */
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java","creaTicket.java");
        pb.directory(new File("src\\Ejercicio6"));
        pb.inheritIO();
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src\\Ejercicio6\\ticket.txt")));
        try{
            Process p = pb.start();
            p.waitFor();
            System.out.println("Proceso terminado");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
