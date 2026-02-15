package common;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class InputReader {
    private InputReader() {
    }

    public static List<String> readInput(String name) {
        try {
            return readInputInternal(name);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static List<String> readInputInternal(String name) throws IOException {
        ClassLoader classLoader = InputReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(name);

        if (inputStream == null) {
            throw new IOException("Resource not found: " + name);
        }

        try (InputStreamReader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(in)) {
            return reader.lines().toList();
        }
    }
}
