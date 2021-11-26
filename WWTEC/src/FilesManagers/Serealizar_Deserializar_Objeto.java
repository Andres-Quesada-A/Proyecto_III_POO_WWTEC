/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesManagers;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serealizar_Deserializar_Objeto {
    public static boolean serializarObjeto(String direccionArchivo, Serializable objeto) {
        boolean sw = false;
        try (FileOutputStream fos = new FileOutputStream(direccionArchivo);
                ObjectOutputStream salida = new ObjectOutputStream(fos);) {
            salida.writeObject(objeto);
            sw = true;
        } catch (Exception e) {
            System.out.println("No se puede serializar el objeto");
        }
        return sw;
    }

    public static <E> E deserializarObjeto(String direccionArchivo, Class<E> claseObjetivo) {
        E objeto = null;
        System.out.println("Direccion: " + direccionArchivo);
        try (FileInputStream fis = new FileInputStream(direccionArchivo);
            ObjectInputStream entrada = new ObjectInputStream(fis);) {
            System.out.println("Reconoció el archivo");
            objeto = (E) entrada.readObject();
        } catch (Exception e) {
            System.out.println("No se puede deserializar el objeto");
        }
        return objeto;
    }

}
