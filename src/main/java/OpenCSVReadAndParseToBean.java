import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReadAndParseToBean {
    private static final String CSV_FILE_PATH = "./src/main/resources/users_details.csv";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            {
                CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(CSVUser.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // READS ALL CSV CONTENTS INTO MEMORY (NOT SUITABLE FOR LARGE CSV FILES)
                List<CSVUser> csvUsers = csvToBean.parse();
                for (CSVUser csvUser : csvUsers) {
                    System.out.println("Name : " + csvUser.getName());
                    System.out.println("Email : " + csvUser.getEmail());
                    System.out.println("PhoneNumber : " + csvUser.getPhoneNumber());
                    System.out.println("Country : " + csvUser.getCountry());
                    System.out.println("============================");
                }
            }
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}