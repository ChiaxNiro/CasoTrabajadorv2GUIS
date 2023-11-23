import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GestorArchivo {
    public static void crearArchivo(String ruta, String contenido){
        Path archivo= Paths.get(ruta);
        try{
            Files.write(archivo, contenido.getBytes());
        }catch(IOException e){
            System.err.println("El archivo no pudo ser creado ");
        }

    }

    public static String leerArchivos(String ruta){
        Path archivo= Paths.get(ruta);
        String contenido = " ";
        try{
            contenido=new String (Files.readAllBytes(archivo));
        }catch(IOException e){
            System.err.println("El archivo no pudo ser leido ");
        }return contenido;
    }


    public static void agregarLinea(String ruta, String contenido){
        String oldFile=leerArchivos(ruta);
        crearArchivo(ruta, oldFile+"\n"+contenido);
    }

    public static void borrarArchivo(String ruta){
        Path archivo= Paths.get(ruta);
        try{
            Files.deleteIfExists(archivo);
        }catch(IOException e){
            System.err.println("El archivo no pudo ser eliminado ");
        }


    }
}