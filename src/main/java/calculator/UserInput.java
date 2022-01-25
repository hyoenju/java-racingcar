package calculator;

import java.util.Scanner;
import java.io.IOException;

public class UserInput {

    private Printer printer = new Printer();
    private Scanner scan = new Scanner(System.in);
    public String[] splittedInput;

    public UserInput() throws IOException {
        String userInput = "";
        try {
            userInput = console();
            validateUserInput(userInput);
        } catch (IllegalArgumentException e) {
            printer.printErrorMessage(e.getMessage());
        }
        splittedInput = split(userInput);
    }

    private String console() throws IOException {
        printer.printInputMessage();
        return scan.nextLine();
    }

    private String[] split(String userInput) {
        return userInput.trim().split("\\s+");
    }

    private void validateUserInput(String userInput) {
        isEmptyString(userInput);
    }

    private void isEmptyString(String userInput) {
        if (userInput.trim().equals("")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}