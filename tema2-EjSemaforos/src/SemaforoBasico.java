import java.util.concurrent.Semaphore;

public class SemaforoBasico implements  Runnable {

    Semaphore semaforo = new Semaphore(3);

    @Override
    public void run() {
        try {
            semaforo.acquire();
            System.out.println("Cliente siendo atendido");
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("Cliente ha terminado de ser atendido");
            semaforo.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SemaforoBasico sb = new SemaforoBasico();
        for(int i=0; i<10; i++) {
            new Thread(sb).start();
        }
    }
}