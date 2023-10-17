public class HiloRunnable implements Runnable {
    public static void main(String[] args) {
        HiloRunnable runnable1=new HiloRunnable();
        HiloRunnable runnable2=new HiloRunnable();
        Thread hilo1=new Thread(runnable1);
        Thread hilo2=new Thread(runnable2);
        hilo1.start();
        hilo2.start();

    }
    public void run(){
        for (int i=0;i<=5;i++){
            System.out.println("Hilo "+Thread.currentThread().getId()+": "+i);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("El hilo se ha interrumpido!");
            }
        }
    }
}
