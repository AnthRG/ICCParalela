package app.practica1.suma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Suma {
    private static final int NUM_HILOS = 4;
    private static final int SIZE = 1000000;
    private static long[] resultados = new long[NUM_HILOS];

    public static void main(String[] args) throws InterruptedException {
        long[] arreglo = archivoReader();

        SumaHilo(arreglo);
        SumaLineal(arreglo);
    }

    static void SumaLineal(long[] arreglo) {
        long suma = 0;
        long inicioTiempo = System.nanoTime();
        for (Long num : arreglo) {
            suma += num;
        }
        long finTiempo = System.nanoTime();
        System.out.println("La suma total (secuencial): " + suma);
        System.out.printf("Tiempo de ejecucion secuencial es de: %.3f ms%n", (finTiempo - inicioTiempo) / 1000000.0);

    }
    static void SumaHilo(long[] arreglo) throws InterruptedException {
        int parte = SIZE / NUM_HILOS;
        List<SumThread> sumadores = new ArrayList<>();


        for (int i = 0; i < NUM_HILOS; i++) {
            int inicio = i * parte;
            int fin = (i == NUM_HILOS - 1) ? SIZE : inicio + parte;
            SumThread t = new SumThread(arreglo, inicio, fin);
            sumadores.add(t);
        }

        long inicioTiempo = System.nanoTime();

        for(SumThread t : sumadores){
            t.start();
        }
        long sumT = 0;

        for (SumThread s : sumadores) {
            s.join();
            sumT += s.getSum();
        }
        long finTiempo = System.nanoTime();


        System.out.println("Suma total (paralela): " + sumT);
        System.out.printf("Tiempo de ejecucion de los hilos: %.3f ms%n", (finTiempo - inicioTiempo) / 1000000.0);

    }

    static long[] archivoReader() {
        long[] arreglo = new long[SIZE]; // SIZE = 1_000_000
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/app/practica1/datos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null && i < SIZE) {
                try {
                    arreglo[i++] = Long.parseLong(linea.trim());
                } catch (NumberFormatException e) {
                    System.err.println("Línea inválida: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
        return arreglo;
    }
}
