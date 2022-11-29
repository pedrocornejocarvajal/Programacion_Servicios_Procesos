package Ej5_SemaforoAvanzado;

import java.util.concurrent.Semaphore;

public class SemaforoAvanzado implements  Runnable {

    Semaphore carniceria = new Semaphore(4);
    Semaphore charcuteria = new Semaphore(2);
    @Override
    public void run() {
        try {

            carniceria.acquire();
            System.out.println(Thread.currentThread().getName()+ "esta siendo atendido en la carniceria");
            Thread.sleep((long)(Math.random()*10000));
            System.out.println(Thread.currentThread().getName()+" ha terminado de ser atendido en carniceria");
            carniceria.release();

            charcuteria.acquire();
            System.out.println(Thread.currentThread().getName()+" siendo atendido en charcuteria");
            Thread.sleep((long)(Math.random()*10000));
            System.out.println(Thread.currentThread().getName()+" ha terminado de ser atendido en charcuteria");
            charcuteria.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SemaforoAvanzado sb = new SemaforoAvanzado();
        for(int i=0; i<10; i++) {

            Thread hilo = new Thread(sb);
            hilo.setName("Cliente "+i);
            hilo.start();
        }
    }
}