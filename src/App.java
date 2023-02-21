import java.io.File;
import java.util.Scanner;
import Control.*;

public class App {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            File ruta;

            do {
                System.out.println("\nIngrese la ruta de la carpeta: ");
                ruta = new File(sc.nextLine());// "C:\\Users\\HP\\OneDrive\\Escritorio\\U\\septimo\\Ing Software 1";
                                               // Reemplazar por la ruta de la carpeta que se desea analizar
                if (!(ruta.isDirectory())) {
                    System.out.println("\nEsta no es una ruta de carpeta");
                }

            } while (!(ruta.isDirectory()));

            System.out.println("\nIngrese la palabra a buscar: ");
            String palabra = sc.nextLine();// "arar"; Reemplazar por la palabra que se desea buscar

            Carpeta carpeta = new Carpeta(palabra, ruta);

            Archivo archivo = new Archivo(carpeta);

            archivo.leerArchivos();
        }
    }

}
