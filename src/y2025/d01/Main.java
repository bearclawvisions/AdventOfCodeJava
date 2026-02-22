package y2025.d01;

import common.InputReader;
import common.TimingUtils;

import java.util.List;

public class Main {
    static void main() throws Exception {
        List<String> input = InputReader.readInput("202501.txt");

        TimingUtils.timeMethodAndReturnAnswer("Part 1", () -> SecretEntrance.part1(input)); // 1074
        TimingUtils.timeMethodAndReturnAnswer("Part 2", () -> SecretEntrance.part2(input)); // 6254
    }
}
