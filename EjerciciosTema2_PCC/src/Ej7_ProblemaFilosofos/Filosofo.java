package Ej7_ProblemaFilosofos;

public class Filosofo extends Thread {

    private final Mesa mesa;
    private final int numeroFilosofo;
    private final int indiceFilosofo;

    public Filosofo(Mesa m, int comensal){
        this.mesa = m;
        this.numeroFilosofo = comensal;
        this.indiceFilosofo = comensal - 1;
    }

    public void run(){

        while (true) {
            this.esperando();
            this.mesa.cogerTenedores(this.indiceFilosofo);
            this.comiendo();
            System.out.println("Filosofo " + numeroFilosofo + " deja de comer, tenedores libres " + (this.mesa.tenedorIzquierda(this.indiceFilosofo) + 1) + ", " + (this.mesa.tenedorDerecha(this.indiceFilosofo) + 1));
            this.mesa.dejarTenedores(this.indiceFilosofo);
        }

    }

    public void esperando(){

        System.out.println("Filosofo " + numeroFilosofo + " esta esperando");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) {
            System.out.println("Error en la espera");
        }

    }

    public void comiendo(){
        System.out.println("Filosofo " + numeroFilosofo + " esta comiendo");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) {
            System.out.println("Error en el inicio de la comida");
        }
    }

}