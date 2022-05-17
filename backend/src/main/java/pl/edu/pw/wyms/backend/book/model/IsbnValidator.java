package pl.edu.pw.wyms.backend.book.model;

public class IsbnValidator {

    public static boolean isNumeric(String number) {
        return number.matches("[0-9]+");
    }

    public static boolean isValid(String isbn) {
        int sum = 0;
        if(isbn.length() == 10) {
            if (!isNumeric(isbn.substring(0,9))){
                return false;
            }
            for (int i = 0; i < 9; i++) {
                sum += (10 - i) * (isbn.charAt(i) - '0');
            }
            char last = isbn.charAt(9);
            sum += ((last == 'X') ? 10 : (last - '0'));
            if (last == 'X' && 10 == sum % 11) {
                return true;
            }
            if (last - '0' == sum % 11) {
                return true;
            }
        }

        if(isbn.length() == 13) {
            if (!isNumeric(isbn)){
                return false;
            }
            for(int i = 0; i < 12; i++) {
                int digit = isbn.charAt(i) - '0';
                if(i % 2 == 0) {
                    sum +=digit;
                } else {
                    sum += digit * 3;
                }
            }

            if((isbn.charAt(12)) - '0' == 10 - (sum % 10)) {
                return true;
            }
        }

        return false;
    }
}
