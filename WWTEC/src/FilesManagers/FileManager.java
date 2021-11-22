/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesManagers;

import java.awt.Color;
import java.io.*;
import java.util.*;

/*

 */
public class FileManager implements Serializable{
    //Crea un nuevo archivo
    public void createFile (String path){
        File myObj = new File(path);
    }
    //Escribe al final del archivo 
    public void writeToFile(String path, String text){
        try{
            FileWriter myWriter = new FileWriter(path, true);
            myWriter.write(text);
            myWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Sobreescribe el contenido del archivo
    public void rewriteToFile(String path, String text){
        try{
            FileWriter myWriter = new FileWriter(path, false);
            myWriter.write(text);
            myWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Lee el contenido del archivo
    public String readFile (String filePath)
    {
        StringBuilder contentBuider = new StringBuilder();
        try (BufferedReader br = new BufferedReader (new FileReader(filePath)))
        {
            System.out.println("Entró");
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
               contentBuider.append(sCurrentLine).append("\n"); 
            }
            return contentBuider.toString();
        }
        catch (IOException e)
        {
            //e.printStackTrace();
            return null;
        }
        
    }
}
