package supermercado;

import java.util.List;

public class Cajero1 extends Thread {
    private final String nombre;
    private List<Cliente> cola;
    public Cajero1(String nombre, List<Cliente> cola){
        this.nombre=nombre;
        this.cola=cola;
    }
    @Override
    public void run(){
        while(!cola.isEmpty()){
            Cliente cliente= cola.remove(0);
            System.out.println("El cajero "+this.nombre+" está atendiendo al cliente: "+cliente.getNumero());
            try {
              Thread.sleep(cliente.getTiempoAtencion()*1000);
            } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
            }
            System.out.println("Ha finalizado la atención del cliente : " +cliente.getNumero()+". Ha demorado: "+cliente.getTiempoAtencion()+" segundos.");
            
         }
    }

}
