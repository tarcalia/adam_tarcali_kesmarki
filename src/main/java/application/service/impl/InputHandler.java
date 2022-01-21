package application.service.impl;

import application.service.InputService;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Service class for input operations.
 */
@Service
public class InputHandler implements InputService {
    private Scanner input = new Scanner(System.in);

    public InputHandler() {
    }

    public String getStringInput() {
        return input.next();
    }

    public Integer getNumericInput() {
        String answer = input.next();
        while (!isNumeric(answer)) {
            System.out.println("Not valid number given");
            answer = input.next();
        }
        return Integer.valueOf(answer);
    }

    public boolean isNumeric(String number) {
        return Pattern.compile("[0123456789]{1,25}").matcher(number).matches();
    }
}