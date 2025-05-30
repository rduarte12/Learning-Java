package classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String emailAddress;

    public String getEmail() {
        return emailAddress;
    }


    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            String expression = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                this.emailAddress = email;
            } else {
                throw new IllegalArgumentException("Email inválido: " + email);
            }
        } 


    }

}
