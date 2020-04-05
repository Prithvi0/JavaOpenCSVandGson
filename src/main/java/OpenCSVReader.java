import com.opencsv.CSVReader;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    private static final String CSV_FILE_PATH = "./src/main/resources/users_details.csv";

    public static void main(String[] args) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
            {
                // READING ALL THE RECORDS AT ONCE BY ONE INTO A LIST ARRAY
                List<String[]> records = csvReader.readAll();
                for (String[] record : records) {
                    System.out.println("Name : " + record[0]);
                    System.out.println("Email : " + record[1]);
                    System.out.println("Phone : " + record[2]);
                    System.out.println("Country : " + record[3]);
                    System.out.println("--------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}