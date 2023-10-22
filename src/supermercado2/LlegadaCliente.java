package supermercado2;

import java.util.concurrent.CountDownLatch;

public class LlegadaCliente extends Thread {
    private Cola cola;
    private volatile boolean finalizar;
    private final CountDownLatch latch;
    private int numCliente;
    public LlegadaCliente(Cola cola,CountDownLatch latch){
        this.cola=cola;
        this.latch=latch;
        this.finalizar=false;
        this.numCliente=0;
    }
    @Override
    public void run(){
        int tiempoLlegada;
        Cliente cliente;
        while(!finalizar){
            tiempoLlegada=(int)(Math.random()*5+1);
            try {
                Thread.sleep(tiempoLlegada*1000);
              } catch (Exception e) {
               System.out.println("Error: "+e.getMessage());
              }
              numCliente++;
              System.out.println("Llego el cliente " +numCliente+" despues de "+tiempoLlegada+" segundos");
              cliente=new Cliente(numCliente);
              cola.agregarCliente(cliente);

        }
        latch.countDown();
    }
    public synchronized void detener(){
        if (!finalizar){
            System.out.println("Se cierra la tienda");
            finalizar=true;
        }
        else{
            System.out.println("La tienda esta cerrada");
        }
    }
}
