package uned.webtechnologies.shop.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class StringUtils {
    private static final String separator = ", ";

    public static String getStringFromErrors(Errors errors) {
        String message = "";
        for (ObjectError error : errors.getAllErrors()) {
            message += error.getDefaultMessage() + separator;
        }
        return replaceLast(message, separator, ".");
    }

    public static String replaceLast(String str, String original, String replaced) {
        int ind = str.lastIndexOf(original);
        if (ind >= 0)
            str = new StringBuilder(str).replace(ind, ind + 1, replaced).toString();
        return str;
    }

}
