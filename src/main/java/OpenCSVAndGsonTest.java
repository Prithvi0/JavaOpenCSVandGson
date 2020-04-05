import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCSVAndGsonTest {
    private static final String CSV_FILE_PATH = "./src/main/resources/users_details.csv";
    private static final String JSON_FILE_PATH = "./src/main/resources/user_details.json";

    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        CsvToBeanBuilder<CSVUser> CsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        CsvToBeanBuilder.withType(CSVUser.class);
        CsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<CSVUser> csvToBean = CsvToBeanBuilder.build();
        List<CSVUser> csvUsers = csvToBean.parse();
        Gson gson = new Gson();
        String json = gson.toJson(csvUsers);
        FileWriter writer = new FileWriter(JSON_FILE_PATH);
        writer.write(json);
        writer.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_FILE_PATH));
        CSVUser[] userObject = gson.fromJson(bufferedReader, CSVUser[].class);
        List<CSVUser> csvUserList = Arrays.asList(userObject);
    }
}