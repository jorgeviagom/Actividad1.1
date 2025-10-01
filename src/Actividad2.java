import java.io.IOException;
import java.nio.file.*;

public class Actividad2 {

    public static void main(String[] args) {
        // OBTENGO EL DIRECTIO ACTUAL Y LO CONVIERTO EN RUTA RELATIVA
        Path directorioTrabajo = Paths.get("").toAbsolutePath();

        System.out.println("Contenido del directorio: " + directorioTrabajo);

        try (DirectoryStream<Path> contenidoDirectorio = Files.newDirectoryStream(directorioTrabajo)) {
            for (Path elementoDirectorio : contenidoDirectorio) {
                if (Files.isDirectory(elementoDirectorio)) {
                    System.out.println("Directorio --> " + elementoDirectorio.getFileName());
                } else{
                    System.out.println("Archivo --> " + elementoDirectorio.getFileName());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el directorio: " + e.getMessage());
        }
    }
}
