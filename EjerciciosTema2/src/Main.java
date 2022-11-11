public class Main {
    public static void main(String[] args) {

        Thread h = Thread.currentThread();
        System.out.println(h.getName());
        System.out.println(h.getState());
        System.out.println(h.getId());
        System.out.println(h.isDaemon());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("miau");
            }
        }
    }
}