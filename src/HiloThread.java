public class HiloThread extends Thread {
    public static void main(String[] args) {
        HiloThread hilo1=new HiloThread();
        HiloThread hilo2=new HiloThread();
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
