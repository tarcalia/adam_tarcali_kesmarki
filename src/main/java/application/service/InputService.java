package application.service;

/**
 * Interface for input operations.
 */
public interface InputService {

    /**
     * Get String input from user
     * @return the given input from the user.
     */
    String getStringInput();

    /**
     * Get Integer input from user
     * @return the given input from the user.
     */
    Integer getNumericInput();

    /**
     * Determine if given string is convertible to Integer or not
     * @param number wihch will be checked
     * @return true if given string is convertible to Integer.
     */
    boolean isNumeric(String number);
}
