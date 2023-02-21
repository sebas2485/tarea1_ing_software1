package Control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
    private Carpeta carpeta;

    public Archivo(Carpeta carpeta) {
        this.carpeta = carpeta;
    }

    public void leerArchivos() {
        int contador = 0;
        int cont = 0;
        for (File archivo : carpeta.getRuta().listFiles()) {
            if (archivo.isFile()) {
                String extension = obtenerExtension(archivo);

                if (extension.equals("txt") || extension.equals("xml") || extension.equals("json")
                        || extension.equals("csv")) {
                    try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                        String linea;
                        String[] separar;
                        cont = 0;

                        while ((linea = lector.readLine()) != null) {

                            separar = linea.split(",|\\(| |:|;");

                            cont += carpeta.contarPalabraEnLinea(separar, carpeta.getPalabra());
                            contador += carpeta.contarPalabraEnLinea(separar, carpeta.getPalabra());

                        }

                    } catch (IOException e) {
                        System.err.println(
                                "Error al leer el archivo " + archivo.getName() + ": " + e.getMessage());
                    }
                }

            }
            System.out
                    .println("El archivo: " + archivo.getName() + " Contiene la palabra: \"" + carpeta.getPalabra()
                            + "\"" + cont);
        }

        System.out.println("La palabra \"" + carpeta.getPalabra() + "\" aparece " + contador
                + " veces en los archivos de texto en la carpeta " + carpeta);
    }

    public String obtenerExtension(File archivo) {
        String nombre = archivo.getName();

        int indice = nombre.lastIndexOf(".");

        if (indice >= 0 && indice < nombre.length() - 1) {
            return nombre.substring(indice + 1);
        } else {
            return "";
        }
    }

}
