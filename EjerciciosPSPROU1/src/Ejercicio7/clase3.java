package Ejercicio7;

import java.util.Scanner;

public class clase3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip;
        String[] ipArray;
        int octeto;
        while (sc.hasNextLine()) {
            ip = sc.nextLine();
            ipArray = ip.split("\\.");
            octeto = Integer.parseInt(ipArray[0]);

            if (octeto <= 127) {
                System.out.println("Esta ip:" + ip + " pertenece a la clase A");
            } else if (octeto >= 192) {
                System.out.println("Esta ip:" + ip + " pertenece a la clase C");
            } else {
                System.out.println("Esta ip:" + ip + " pertenece a la clase B");
            }

        }
    }
}
