package y2025.d03;

import common.InputReader;
import common.TimingUtils;

import java.util.List;

public class Main {
    static void main() throws Exception {
        List<String> input = InputReader.readInput("202503.txt");

        TimingUtils.timeMethodAndReturnAnswer("Part 1", () -> Lobby.part1(input));
    }
}
