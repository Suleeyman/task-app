package utils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringInputReader implements InputReader<String> {
    Scanner scanner;

    public StringInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String read(String prompt, String invalidMsg) {
        System.out.print(prompt);
        while (true) {
            try {
                return scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.print(invalidMsg);
            }
        }
    }
}
