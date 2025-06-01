package app;

import app.practica1.generator.GeneradorDatos;
import app.practica1.suma.Suma;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GeneradorDatos.main(args);
        Suma.main(args);
    }
}