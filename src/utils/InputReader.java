package utils;

public interface InputReader<T> {
    T read(String prompt, String invalidMsg);
}
