package app.practica1.suma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Suma {
    private static final int NUM_HILOS = 20;
    private static final int SIZE = 1000000;
    private static long[] resultados = new long[NUM_HILOS];

    public static void main(String[] args) {
        int[] arreglo = new int[SIZE];
        arreglo = archivoReader(arreglo);

        SumaHilo(arreglo);
        SumaLineal(arreglo);
    }

    static void SumaLineal(int[] arreglo) {
        long suma = 0;
        long inicioTiempo = System.nanoTime();
        for (int num : arreglo) {
            suma += num;
        }
        long finTiempo = System.nanoTime();
        System.out.println("La suma total (secuencial): " + suma);
        System.out.printf("Tiempo de ejecucion secuencial es de: %.3f ms%n", (finTiempo - inicioTiempo) / 1_000_000.0);

    }

    static void SumaHilo(int[] arreglo) {
        // Crear hilos
        Thread[] hilos = new Thread[NUM_HILOS];
        int parte = SIZE / NUM_HILOS;

        for (int i = 0; i < NUM_HILOS; i++) {
            final int indice = i;
            hilos[i] = new Thread(() -> {
                int inicio = indice * parte;
                int fin = (indice == NUM_HILOS - 1) ? SIZE : inicio + parte;
                long sumaParcial = 0;
                for (int j = inicio; j < fin; j++) {
                    sumaParcial += arreglo[j];
                }
                resultados[indice] = sumaParcial;
            });
        }

        long inicioTiempo = System.nanoTime();

        for (Thread hilo : hilos) {
            hilo.start();
        }
        try {
            for (Thread hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finTiempo = System.nanoTime();


        // Sumar los resultados parciales
        long sumaTotal = 0;
        for (long parcial : resultados) {
            sumaTotal += parcial;
        }

        System.out.println("Suma total (paralela): " + sumaTotal);
        System.out.printf("Tiempo de ejecucion de los hilos: %.3f ms%n", (finTiempo - inicioTiempo) / 1_000_000.0);

    }

    static int[] archivoReader(int[] arreglo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/app/practica1/datos.txt"))) {
            String linea;
            int i = 0;
            while ((linea = reader.readLine()) != null && i < SIZE) {
                arreglo[i++] = Integer.parseInt(linea.trim());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
        return arreglo;
    }

}
