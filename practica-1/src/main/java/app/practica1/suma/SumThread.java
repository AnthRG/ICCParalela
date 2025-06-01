package app.practica1.suma;

import java.util.ArrayList;
import java.util.List;

public class SumThread extends Thread {
    List<Long> datos;
    Long sum;

    public SumThread(List<Long> datos) {
        this.sum = 0L;
        this.datos = datos;
    }

    public void run() {
        for (Long s : datos) {
            sum += (s);
        }
    }

    public List<Long> getDatos() {
        return datos;
    }

    public void setDatos(List<Long> datos) {
        this.datos = datos;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}
