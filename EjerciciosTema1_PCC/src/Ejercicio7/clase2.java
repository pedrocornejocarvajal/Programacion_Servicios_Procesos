package Ejercicio7;

import java.util.Scanner;

public class clase2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip;
        String[] direccionOctetos;
        int octeto;
        for (int i = 0; i < 10; i++) {
            ip = sc.nextLine();
            direccionOctetos = ip.split("\\.");
            octeto = Integer.parseInt(direccionOctetos[0]);
            if(octeto <= 223){
                System.out.println(ip);
            }
        }
    }
}
