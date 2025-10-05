import java.io.IOException;
import java.nio.file.*;

public class Actividad3 {

    public static void main(String[] args) {
        // OBTENGO EL DIRECTORIO ACTUAL Y LO CONVIERTO EN RUTA RELATIVA
        Path directorioTrabajo = Paths.get("").toAbsolutePath(); //Paths.get("") DEVUELVE DIRECTORIO ACTUAL

        System.out.println("Contenido del directorio: " + directorioTrabajo);

        try (DirectoryStream<Path> contenidoDirectorio = Files.newDirectoryStream(directorioTrabajo)) {
            //RECORREMOS CADA ELEMENTO QUE HAY EN EL DIRECTORIO
            for (Path elementoDirectorio : contenidoDirectorio) {
                //COMPROBAMOS SI EL ELEMENTO ES UN DIRECTORIO
                if (Files.isDirectory(elementoDirectorio)) {
                    System.out.println("Directorio --> " + elementoDirectorio.getFileName());
                } else{
                    //SI NO ES DIRECTORIO, ES UN ARCHIVO
                    System.out.println("Archivo --> " + elementoDirectorio.getFileName());
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error al leer el directorio. " + ioe.getMessage());
        }
    }
}
