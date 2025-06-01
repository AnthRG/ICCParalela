# este proyecto tiene 3 clases y un main

#### Suma.Java
#### GeneradorDatos.java
#### SumThread.java


## uno por uno:
#### SumThread.java es la clase de los hilos, cuando se hace start luego de ser iniciada, suma un long[] de un valor inicial al final

#### GeneradorDatos.java genera un archivo con 100,000 numeros random separados por /n

#### Suma.java corre una suma total del archivo completo tanto en secuencial como en  paralelo, el numero de hilos es una variable llamada NUM_HILOS de la clase que puede ser aumentada o disminuida para cambiar el numero de hilos

#### Main.java corre el generador y suma.java cada clase puede ser corrida por si sola, solo es requerido que Generador de datos se use cada vez que se requiera re randomizar el .txt



### notas:

no fui capaz de que me diera los resultados esperados, por eso en la caja de el docx
![image](https://github.com/user-attachments/assets/588918df-8672-4cd9-900e-ac4107a9faa4)
mi eficiencia fue bajando en vez de subir era como que lo corria secuencialmente y no logre usar el virtual threads porque no lo entendi
mi codigo considero correcto, incluso al intentar depurar con compañeros no logramos dar con el "que me falta o que esta pasando"
la pc que se uso para la practica usa windows con 20 procesadores logicos y 10 cores (i9 10th gen)
![image](https://github.com/user-attachments/assets/3be251f1-96bc-42ff-a8da-f50bf5f9cb20)

