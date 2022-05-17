package pl.edu.pw.wyms.backend.reader.model;

public class EmailValidator {
    public static boolean isValid(String email) {
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]" +
                "+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }
}
