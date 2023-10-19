# PROGRAMACIÓN MULTIHILO
- Java proporciona un soporte integral para la programación multihilo a través de su API de concurrencia, que incluye clases y métodos que facilitan la creación, gestion y coordinación de hilos
- Algunos conceptos claves en la programción multihilo en java son:
 1. Thread (Hilo): La clase **Thread** es la base para crear y controlar hilos en java. Puedes crear un nuevo hilo extendiendo la clase **Thread** y sobreescribiendo el método **run**, que define el código a ejecutar en ese hilo
 2. Runnable: La interfaz **Runnable** también se utiliza para crear hilos en java. Puedes implementar la interfaz Runnable y proporcionar la implementación del método **run()** para definir el código que se ejecutará en el hilo
 3. **Sincronización**: Cuando varios hilos acceden a recursos compartidos, es necesario sincronizar el acceso a esos recursos para evitar condiciones de carrera y garantizar la consistencia de los datos .Java prporciona bloqueos (**synchronized**) y otros mecanismo de sincronización para lograr esto
 4. **Monitores y wait/notify**: Java ofrece monitores y los métodos **wait()**,**notify()**,**notifyAll()**, para coordinar la ejecución entre hilos.Estos mecanismos permiten a los hios esperar hata que se cumpla una cierta condición y luego notificar a otros hilos cuando se produce algun cambio.
 5. Clase de utilidad: Java porporciona varias clases de utilidad  en el paquete java.util.concurrent para ayudar en la programaciónmultihilo, como **Executor,ExecutorService,ThreadPoolExecutor,CountDownLatch, CyclicBarrier**, entre otros.
 - **notify()**: Es un método que se utiliza en el contexto de la programación multihilo para controlar la sincronización y la comunicación entre hilos. Este método se llama en un objeto y notific a otro hilo que esta esperando en ese objeto que puede continuar la ejecución.
 - **synchronized()**:Para sincronizar bloques de código, es decir solo un hilo puede acceder al bloque de código, sirve para evitar que dos hilos puedan acceder al mismo código
 - **El método poll()**: en Java se utiliza en el contexto de las estructuras de datos tipo cola **Queue o Duque** , para eliminar y devolver el elemento en la parte  frontal de la cola, si la cola no está vacía. Si la cola está vacía el metodo **poll()** devuelve null
## ESTADO DE UNA TAREA
Un **thread** pueden encontrarse en uno de los siguientes estados:
- **Nuevo**: El thread entra en ese estado l crear la instancia de la clase Thread asociada, permaneciendo en él hasta que se produzca la llamada a **start()**. Un thread en el estado "nuevo" aun no se considera vivo
- **Preparado**: Un thread entra en este estado al invocar el método start(),aunque puede regresar a él después de haber estado en ejecución, dormido o bloqueado. Un thread en estado "preparado" ya se considera vivo.
- **Ejecución**: El thread  entra en este estado cuando el cargador el **scheduler** lo selecciona para su ejecución
- **Esperando/bloqueado/dormido**: Son tres estados combinados en uno y se caracteriza porque el thread aún está vivo pero no preparado, pudiendo estar dormido, bloqueado a la espera de un recurso o en espera .
- **Finalizado**: Un thread se considera que ha finalizado cuando termina la ejecución del  método run(). **Una vez que el thread finaliza no puede volver de nuevo al estado preparado.
## METODO DE COMUNICACIÓN
Existen tres métodos **Object** que permite enviar señales unos  threads a otros, cuando estos estan ejecutando bloques de código **synchoronized**, condiconando la ejecución de uno de esos bloques a la del otro.
Estos métodos son **invocados en el interior de un bloque synchronized** sobre el objeto que se adquiere el monitor 
- **wait()**. Cuando un thread invoca a este método sobre un objeto, libera  el monitor del mismo y pasa al estado **esperado**, estado que permanecerá hasta que reciba una señal por parte de thread que ese momneto tenga el monitor del objeto para poder continuar su ejecución.
- **notify**: Al invocarlo se envía una señal al threadque hizo la llamada a **wait()**. A partir de ese momento, el thread podrá continuar su ejecución,pasando al estado de **preparado**.
- **notifyAll()**: Sy hay varios threads que han invocado al método wait() sobre el objeto, la llamada a nofity() afectará solamente a uno de elos. Para notificar a todos los threads que estan a la espera se utiliza notifyAll().
