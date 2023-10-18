package peluqueria;

import java.util.LinkedList;
import java.util.Queue;

public class Peluqueria {
    private static final int NUM_PELUQUERAS=3;
    private static final int NUM_CLIENTE=10;
    private Queue<Cliente> colaCliente=new LinkedList<>();
    Object lock=new Object(); //Objeto de bloqueo
    private Thread[] peluqueras;

    public Peluqueria(){
        peluqueras=new Thread[NUM_PELUQUERAS];
        for (int i=0;i<NUM_PELUQUERAS;i++){
            peluqueras[i]=new Thread(new Peluquera(this,"Peuquera"+(i+1)));
        }
    }
    public void iniciar(){
        for(Thread peluquera:peluqueras){
            peluquera.start();
        }
        for(int i=1;i<=NUM_CLIENTE;i++){
            Cliente cliente=new Cliente("Cliente"+i);
            agregarClientes(cliente);
        }
    }

    public void agregarClientes(Cliente clente){
         synchronized(lock){
             colaCliente.offer(clente);
             lock.notify();

         }
    }
    public Cliente obtenerCliente()throws InterruptedException{
        synchronized(lock){
            while(colaCliente.isEmpty()){
                lock.wait();
            }
            return colaCliente.poll();
        }

    }

}
