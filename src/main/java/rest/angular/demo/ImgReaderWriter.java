package rest.angular.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.Base64;

public  class ImgReaderWriter {

    @Value("${local.path}")
    private static String localPath="images\\";

    public static String encoder(String imagePath) {
        String base64Image = "";
        File file = new File(localPath+imagePath);
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
        if(base64Image.contains(",")){
            base64Image = base64Image.split(",")[1];
        }
        try (FileOutputStream imageOutFile = new FileOutputStream(localPath+pathFile)) {
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
    public static boolean deleteImg( String pathFile){
        File f= new File(localPath+pathFile);
        if(f.delete())
            return true;
        else
            return false;
    }
}
