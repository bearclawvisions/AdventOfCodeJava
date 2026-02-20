package y2025.d01;

import common.InputReader;
import common.TimingUtils;

import java.util.List;

public class Main {
    static void main() throws Exception {
        List<String> input = InputReader.readInput("202501.txt");

        int result = TimingUtils.timeMethod("Part 1", () -> SecretEntrance.part1(input));
        System.out.println("Part 1: " + result);

//        long startTime = System.nanoTime();
//        int result = SecretEntrance.part1(input);
//        long endTime = System.nanoTime();
//        long durationMs = (endTime - startTime) / 1_000_000;
//        System.out.println("Part 1: " + result + " - Execution time: " + durationMs + " ms");
    }
}
