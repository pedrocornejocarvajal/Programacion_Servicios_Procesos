package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Recoleccion implements Runnable {
    public static Semaphore semaforoRecolector = new Semaphore(4);
    public static Semaphore semaforoConsumidor = new Semaphore(4);
    private boolean salirEjecucion = false;

    public int recoleccion;

    public int consumicion;

    public static int recaudacionTotal;





    public void recolector() {
        try {
            semaforoRecolector.acquire();   // Adquirimos un permiso para pasar por el semáforo
            recoleccion = (int) (4 + Math.random() * 21);
            recaudacionTotal = recaudacionTotal + recoleccion;
            System.out.println(Thread.currentThread().getName() + " ha recolectado " + recoleccion);
            System.out.println("La recaudacion actual total es " + recaudacionTotal);
            Thread.sleep(10000);// tiempo random
            semaforoRecolector.release();   // Dejamos libre el permiso del semáforo que estabamos ocupando
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumidor() {
        try {
            semaforoConsumidor.acquire();  // Adquirimos un permiso para pasar por el semáforo
            Thread.sleep((long) (Math.random() * 10000));    // tiempo random
            consumicion = (int) (4 + Math.random() * 21);
            recaudacionTotal = recaudacionTotal - consumicion;
            System.out.println(Thread.currentThread().getName() + "  ha recogido " + consumicion);
            System.out.println("La recaudacion actual total es " + recaudacionTotal);
            semaforoConsumidor.release();  // Dejamos libre el permiso del semáforo que estabamos ocupando
        } catch (InterruptedException e) {
            System.err.println("Error, se ha interrumpido el hilo con código de error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    /***
     *
     *
     */
    public void run() {

        while (!salirEjecucion) {
            if (semaforoRecolector.availablePermits() > 0 ) {
                recolector();
                salirEjecucion = true;
            }
            if (semaforoConsumidor.availablePermits() > 0) {
                consumidor();
                salirEjecucion = true;
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 20; i++) {
            Thread hilo = new Thread(new Recoleccion());
            hilo.setName("Hilo " + i);
            hilo.start();
            Thread.sleep(1000);
        }
    }
}