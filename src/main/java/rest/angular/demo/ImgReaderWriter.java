package rest.angular.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Base64;

public  class ImgReaderWriter {//klasa do obslugi  zapisu i odczytywania zdjec do tablicy bajtow

    private static String LOCAL_PATH ="images\\";//scieżka zapisu zdjec dostarczona przez klienta

    public static String encoder(String imagePath) {//odczytanie obrazu do tablicy bajtów
        String base64Image = "";
        File file = new File(LOCAL_PATH +imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return base64Image;
    }

    public static boolean decoder(String base64Image, String pathFile) {//metoda do zapisu zdjecia w okreslonym miejscu
        if(base64Image.contains(",")){
            base64Image = base64Image.split(",")[1];
        }
        try (FileOutputStream imageOutFile = new FileOutputStream(LOCAL_PATH +pathFile)) {
            //konwersja bajtow do formy pliku
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
            return false;
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
            return false;
        }
    }
    public static boolean deleteImg( String pathFile){//metoda do usuniecia zdjecia przy usuwaniu obiektu z bazy danych
        File f= new File(LOCAL_PATH +pathFile);
        if(f.delete())
            return true;
        else
            return false;
    }
}
