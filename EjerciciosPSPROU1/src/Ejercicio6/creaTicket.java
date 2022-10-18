package Ejercicio6;

import java.util.Scanner;

public class creaTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int codigoProducto, cantidad;
        double precioProducto;
        //System.out.println("Introduce el codigo: ");
        codigoProducto = sc.nextInt();
        //System.out.println("Introduce el precio: ");
        precioProducto = sc.nextDouble();
        //System.out.println("Introduce la cantidad: ");
        cantidad = sc.nextInt();
        sc.close();
        //TicketCompra nuevoTicket = new TicketCompra(codigoProducto,precioProducto,cantidad);
        System.out.println(codigoProducto +"-"+precioProducto+"-"+cantidad+"-"+precioProducto*cantidad);
    }
}
