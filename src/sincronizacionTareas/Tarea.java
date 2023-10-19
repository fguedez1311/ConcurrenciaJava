package sincronizacionTareas;

public class Tarea implements Runnable {

    Acceso ac;
    public Tarea(){
        ac=new Acceso();
    }

    @Override
    public void run() {
        synchronized(ac){
            int actual=ac.getCont();
            actual++;
            try {
                  Thread.sleep(100);

            } catch (InterruptedException e) {}
            ac.setCont(actual);
            System.out.println("Total de acceso: "+ac.getCont());
        }
       
    }
    
}
