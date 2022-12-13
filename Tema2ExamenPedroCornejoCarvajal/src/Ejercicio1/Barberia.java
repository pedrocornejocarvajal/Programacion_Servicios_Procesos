package Ejercicio1;

import java.util.concurrent.Semaphore;

public class Barberia implements Runnable {
    public static Semaphore semaforoSilla = new Semaphore(4);
    public static Semaphore semaforoBarbero = new Semaphore(2);
    private boolean sillaEscogida = false;
    private boolean atentidoBarbero = false;
    private boolean salirBarberia = false;

    public void silla() {
        try {
            semaforoSilla.acquire();   // Adquirimos un permiso para pasar por el semáforo
            System.out.println(Thread.currentThread().getName() + " se ha sentado en la silla");
            Thread.sleep(10000);    // tiempo random
            semaforoSilla.release();   // Dejamos libre el permiso del semáforo que estabamos ocupando
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void barbero() {
        try {
            semaforoBarbero.acquire();  // Adquirimos un permiso para pasar por el semáforo
            System.out.println(Thread.currentThread().getName() + " siendo atendido por el barbero");
            Thread.sleep((long)(Math.random()*10000));    // tiempo random
            System.out.println(Thread.currentThread().getName() + " ha terminado de pelarse");
            semaforoBarbero.release();  // Dejamos libre el permiso del semáforo que estabamos ocupando
        } catch (InterruptedException e) {
            System.err.println("Error, se ha interrumpido el hilo con código de error: " +  e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    /***
     * Comprobamos si hay sitio en los puestos de los barberos, en caso de que lo haya es atendido y termina el hilo. En caso de que no haya sitio comprobamos que haya silla libre y en caso de que si
     * haya silla libre esperamos a que se quede un hueco libre en los barberos para ser atendido y finalizar la ejecicion. En caso de que no haya sitio en ningun puesto el hilo acaba
     * porque no hay sitio para el mismo en la peluqueria
     *
     */
    public void run() {
        while (!salirBarberia) {
                if (semaforoBarbero.availablePermits() > 0 && !atentidoBarbero) {
                    barbero();
                    atentidoBarbero = true;
                    salirBarberia = true;
                } else if (semaforoSilla.availablePermits() > 0 && !sillaEscogida) {
                    sillaEscogida = true;
                    silla();
                } else if (!atentidoBarbero && !sillaEscogida){
                    salirBarberia = true;
                    System.out.println(Thread.currentThread().getName() + " no tiene sitio y se va");
                }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            Thread hilo = new Thread(new Barberia());
            hilo.setName("Hilo " + i);
            hilo.start();
            Thread.sleep(1000);
        }
    }
}