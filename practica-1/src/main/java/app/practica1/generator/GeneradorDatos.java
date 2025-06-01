package app.practica1.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorDatos {
    public static void main(String[] args) {
        String nombreArchivo = "src/main/java/app/practica1/datos.txt";
        int cantidadRegistros = 1000000; // 100,000
        int minimo = 1;
        int maximo = 10000; //10 000

        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < cantidadRegistros; i++) {
                int numero = random.nextInt(maximo - minimo + 1) + minimo;
                writer.write(Integer.toString(numero));
                writer.newLine();
            }
            System.out.println("Archivo generado correctamente con " + cantidadRegistros + " registros.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
