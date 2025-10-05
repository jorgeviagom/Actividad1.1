import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Actividad4 {
    public static void main(String[] args) {

        // OBTENGO EL DIRECTORIO ACTUAL DEL PROYECTO
        Path directorioTrabajo = Paths.get("").toAbsolutePath();

        System.out.println("Listado recursivo de: " + directorioTrabajo);

        //LLAMAMOS AL METODO RECURSIVO
        mostrarContenido(directorioTrabajo);
    }
    public static void mostrarContenido(Path ruta) {
        try (DirectoryStream<Path> contenido = Files.newDirectoryStream(ruta)) {
            //RECORREMOS CADA ELEMENTO DEL PROYECTO
            for (Path elemento : contenido) {

                if (Files.isDirectory(elemento)) {
                    System.out.println("Directorio --> " + elemento.getFileName());
                    //LLAMADA RECURSIVA
                    mostrarContenido(elemento);
                } else {
                    System.out.println("Archivo --> " + elemento.getFileName());
                }
            }

        } catch (IOException ioe) {
            System.out.println("Error al acceder al directorio: " + ruta + " (" + ioe.getMessage() + ")");
        }
    }
}
