import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Actividad1 {
    public static void main(String[] args) {
        Path prueba = null;
        try {
            // CREAR CARPETA
            prueba = Path.of("D:\\Users\\jorge.viagom", "Prueba");

            if (Files.notExists(prueba)) {
                Files.createDirectory(prueba);
                System.out.printf("Carpeta creada en: %s%n", prueba.toAbsolutePath());
            } else {
                System.out.printf("Carpeta ya existente en: %s%n", prueba.toAbsolutePath());
            }

            // CREAR FICHERO1
            Path fichero1 = prueba.resolve("fichero1.txt");
            if (Files.notExists(fichero1)) {
                Files.createFile(fichero1);
                System.out.printf("Fichero1 creado en %s%n", fichero1.toAbsolutePath());
            } else {
                System.out.printf("Fichero1 ya ha sido creado en %s%n", fichero1.toAbsolutePath());
            }

            // CREAR FICHERO2
            Path fichero2 = prueba.resolve("fichero2.txt");
            if (Files.notExists(fichero2)) {
                Files.createFile(fichero2);
                System.out.printf("Fichero2 creado en %s%n", fichero2.toAbsolutePath());
            } else {
                System.out.printf("Fichero2 ya ha sido creado en %s%n", fichero2.toAbsolutePath());
            }

            // CREAR JERARQUIA DE CARPETAS
            Path subcarpetas = Path.of("D:\\Users\\jorge.viagom", "Prueba/Subcarpeta1/Subcarpeta2");
            Files.createDirectories(subcarpetas);
            System.out.printf("Estructura creada: %s%n", subcarpetas.toAbsolutePath());

            // CREAR FICHERO3 EN SUBCARPETA2
            Path fichero3 = subcarpetas.resolve("Fichero3.txt");
            if (Files.notExists(fichero3)) {
                Files.createFile(fichero3);
                System.out.printf("Fichero3 creado en %s%n", fichero3.toAbsolutePath());
            } else {
                System.out.printf("Fichero3 ya ha sido creado en %s%n", fichero3.toAbsolutePath());
            }

        } catch (IOException ioe) {
            System.out.println("Ha ocurrido un error: " + ioe.getMessage());
        }

        // borrarDirectorio(prueba);


    }

    public static void borrarDirectorio(Path path) {
        //ABRIMOS STREAM QUE LISTA TODOS LOS ARCHIVOS Y CARPETAS DENTRO DEL PATH
        try (Stream<Path> listaArchivos = Files.list(path)) {
            //STREAM EN LISTA Y RECORREMOS CADA ARCHIVO O CARPETA
            for (Path archivo : listaArchivos.toList()) {
                // COMPROBAMOS SI ES UN DIRECTORIO
                if (Files.isDirectory(archivo)) {
                    //DIRECTORIO, BORRAMOS RECURSIVAMENTE SU CONTENIDO
                    borrarDirectorio(archivo);
                } else {
                    //SI ES UN ARCHIVO LO BORRA DIRECTAMENTE
                    Files.delete(archivo);
                }
            }
            //BORRADO DEL DIRECTORIO VACIO
            Files.delete(path);
            System.out.println("Directorio borrado correctamente: " + path.toAbsolutePath());
        } catch (IOException ioe) {
            System.out.println("Error al borrar directorio: " + ioe.getMessage());
        }
    }
}
