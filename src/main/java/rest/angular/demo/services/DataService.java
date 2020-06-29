package rest.angular.demo.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;

@Service
public class DataService {


    public static String encoder(String imagePath) {
        String base64Image = "";
        File file = new File(imagePath);
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


    public static boolean decoder(String base64Image, String pathFile) {
        try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
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
}
