# PROGRAMACIÓN MULTIHILO
- Java proporciona un soporte integral para la programación multihilo a través de su API de concurrencia, que incluye clases y métodos que facilitan la creación, gestion y coordinación de hilos
- Algunos conceptos claves en la programción multihilo en java son:
 1. Thread (Hilo): La clase **Thread** es la base para crear y controlar hilos en java. Puedes crear un nuevo hilo extendiendo la clase **Thread** y sobreescribiendo el método **run**, que define el código a ejecutar en ese hilo
 2. Runnable: La interfaz **Runnable** también se utiliza para crear hilos en java. Puedes implementar la interfaz Runnable y proporcionar la implementación del método **run()** para definir el código que se ejecutará en el hilo
 3. **Sincronización**: Cuando varios hilos acceden a recursos compartidos, es necesario sincronizar el acceso a esos recursos para evitar condiciones de carrera y garantizar la consistencia de los datos .Java prporciona bloqueos (**synchronized**) y otros mecanismo de sincronización para lograr esto
 4. **Monitores y wait/notify**: Java ofrece monitores y los métodos **wait()**,**notify()**,**notifyAll()**, para coordinar la ejecución entre hilos.Estos mecanismos permiten a los hios esperar hata que se cumpla una cierta condición y luego notificar a otros hilos cuando se produce algun cambio.
 5. Clase de utilidad: Java porporciona varias clases de utilidad  en el paquete java.util.concurrent para ayudar en la programaciónmultihilo, como **Executor,ExecutorService,ThreadPoolExecutor,CountDownLatch, CyclicBarrier**, entre otros.
