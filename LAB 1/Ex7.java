import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex7 {
    public static String logSecrets(String fName){
        String txt = "";
        File myObj = new File(fName);

        try (BufferedReader br = new BufferedReader(new FileReader(fName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("SECRET")) txt = txt+" "+line;
            }
        } catch (IOException e) {
            System.out.println("IO Error");
            System.exit(0);
        }
        return txt;
    }
}