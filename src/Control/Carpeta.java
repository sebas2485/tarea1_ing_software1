package Control;

import java.io.File;

public class Carpeta {
    private String palabra;
    private File ruta;

    public Carpeta(String palabra, File ruta) {
        this.palabra = palabra;
        this.ruta = ruta;
    }

    public String getPalabra() {
        return palabra;
    }

    public File getRuta() {
        return ruta;
    }

    public int contarPalabraEnLinea(String linea[], String palabra) {
        int contador = 0;
        for (int i = 0; i < linea.length; i++) {

            if (linea[i].equals(palabra)) {

                contador++;

            }
        }

        return contador;
    }

}
