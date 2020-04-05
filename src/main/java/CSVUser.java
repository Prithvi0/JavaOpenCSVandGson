import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone", required = true)
    private String phoneNumber;

    @CsvBindByName(column = "country", required = true)
    private String country;

    public CSVUser(String name, String email, String phoneNumber, String country) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    // METHOD TO RETURN USER DETAILS FROM CSV FILE
    @Override
    public String toString() {
        return "CSVUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
    // METHOD TO RETURN NAME
    public String getName() {
        return name;
    }
    // METHOD TO RETURN E-MAIL
    public String getEmail() {
        return email;
    }
    // METHOD TO RETURN PHONE NUMBER
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // METHOD TO RETURN COUNTRY
    public String getCountry() {
        return country;
    }
}