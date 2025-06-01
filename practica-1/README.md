# este proyecto tiene 3 clases y un main

#### Suma.Java
#### GeneradorDatos.java
#### SumThread.java


## uno por uno:
#### SumThread.java es la clase de los hilos, cuando se hace start luego de ser iniciada, suma un long[] de un valor inicial al final

#### GeneradorDatos.java genera un archivo con 100,000 numeros random separados por /n

#### Suma.java corre una suma total del archivo completo tanto en secuencial como en  paralelo, el numero de hilos es una variable llamada NUM_HILOS de la clase que puede ser aumentada o disminuida para cambiar el numero de hilos

#### Main.java corre el generador y suma.java cada clase puede ser corrida por si sola, solo es requerido que Generador de datos se use cada vez que se requiera re randomizar el .txt
