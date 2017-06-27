/*
 * DavidsCodeLibrary
 * Created by David Grant
 */
package io.github.davidg95.davidscodelibrary.Utilities;

/**
 * Class of general utility methods.
 *
 * @author David
 */
public class Utilities {

    /**
     * Method to check if a string value is a number or not.
     *
     * @param val the String to check
     * @return true if it is a number, false otherwise.
     */
    public static final boolean isNumber(String val) {
        val = val.replace(".", "");
        val = val.replace("-", "");
        return val.matches("[0-9]+");
    }

    /**
     * Method to check if a string value contains a number or not.
     *
     * @param val the string to check.
     * @return true if is contains a number, false otherwise.
     */
    public static final boolean containsNumber(String val) {
        return val.contains("[0-9]+");
    }

    /**
     * Method to check if a string value is an email or not. It checks that there is an "@" symbol a "." symbol, and that the length is greater than 4.
     *
     * @param email the email address to check.
     * @return true if it is an email, false if it is not.
     */
    public static final boolean isEmail(String email) {
        return email.contains("@") && email.contains(".") && email.length() > 4;
    }
}
