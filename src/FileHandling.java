import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        File file = new File("myfile.txt");
        try {
            if(file.createNewFile()) {
                System.out.println("File created:" + file.getName());
            }else {
                System.out.println("File i already exist");
            }
            FileWriter writer = new FileWriter(file);
            writer.write("123");
            writer.close();
            System.out.println("Successfully wrote to file");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Read Error");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Create or Write Error");
            e.printStackTrace();
        }

    }
}
