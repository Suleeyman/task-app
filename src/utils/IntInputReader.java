package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntInputReader implements InputReader<Integer> {
    Scanner scanner;

    public IntInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public Integer read(String prompt, String invalidMsg) {
        while (true) {
            System.out.print("\n\r" + prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print(invalidMsg);
                scanner.nextLine(); // Consomme la ligne incorrecte pour éviter la boucle infinie
            }
        }
    }
}
