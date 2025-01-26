package utils;

import java.util.EnumSet;
import java.util.Scanner;

public class EnumInputReader<E extends Enum<E>> implements InputReader<E> {

    private final Class<E> enumType;
    private final Scanner scanner;

    public EnumInputReader(Class<E> enumType) {
        this.enumType = enumType;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public E read(String prompt, String invalidMsg) {
        System.out.print(prompt + " (" + String.join(", ", enumNames()) + "): ");
        while (true) {
            String input = scanner.nextLine().toUpperCase();
            try {
                return Enum.valueOf(enumType, input);
            } catch (IllegalArgumentException e) {
                System.out.print(invalidMsg +
                        String.join(", ", enumNames()) + ": ");
            }
        }
    }

    private String[] enumNames() {
        return EnumSet.allOf(enumType).stream()
                .map(Enum::name)
                .toArray(String[]::new);
    }
}