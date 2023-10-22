package supermercado2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ApliSupermercado {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);//Espera que los 3 hilos terminen
        Cliente cliente1=new Cliente(1);
        Cliente cliente2=new Cliente(2);
        Cola cola=new Cola();
        LlegadaCliente llegada=new LlegadaCliente(cola,latch);
        Cajero cajero1=new Cajero("Carlos",cola,latch,llegada);
        Cajero cajero2=new Cajero("Luis",cola,latch,llegada);

        long tiempoInicial=System.currentTimeMillis();
        
        llegada.start();
        cajero1.start();
        cajero2.run();
       try {
            latch.await();
       } catch (Exception e) {
         System.out.println("Error: "+ e.getMessage());
       }
       long tiempoFinal=System.currentTimeMillis();
       System.out.println("Tiempo de ejecución: "+(tiempoFinal-tiempoInicial));

        System.out.println("Finaliza el programa principal");

    }
}
