package app.practica1.suma;

import java.util.ArrayList;
import java.util.List;

class SumThread extends Thread {
    private final long[] datos;
    private final int inicio, fin;
    private long sum = 0;

    public SumThread(long[] datos, int inicio, int fin) {
        this.datos = datos;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {

        for (int i = inicio; i < fin; i++) {
            sum += datos[i];
        }
    }

    public Long getSum() {
        return sum;
    }
}
