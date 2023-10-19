package sincronizacionTareas;

public class Ejecucion {
    public static void main(String[] args) {
        Tarea tr=new Tarea();
        Thread t1=new Thread(tr);
        Thread t2=new Thread(tr);
        Thread t3=new Thread(tr);
        t1.start();
        t2.start();
        t3.start();
    }
}
