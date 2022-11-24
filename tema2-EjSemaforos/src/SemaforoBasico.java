import java.util.concurrent.Semaphore;

public class SemaforoBasico implements  Runnable {

    Semaphore carniceria = new Semaphore(3);

    @Override
    public void run() {
        try {
            carniceria.acquire();
            System.out.println(Thread.currentThread().getName()+ "esta siendo atendido en la carniceria");
            Thread.sleep((long)(Math.random()*10000));
            System.out.println(Thread.currentThread().getName()+" ha terminado de ser atendido en carniceria");
            carniceria.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SemaforoBasico sb = new SemaforoBasico();
        for(int i=0; i<10; i++) {
            Thread hilo = new Thread(sb);
            hilo.setName("Cliente "+i);
            hilo.start();
        }
    }
}