package y2025.d02;

import common.InputReader;
import common.TimingUtils;
import y2025.d01.SecretEntrance;

import java.util.List;

public class Main {
    static void main() throws Exception {
        List<String> input = InputReader.readInput("202502.txt");

        TimingUtils.timeMethodAndReturnAnswerAsLong("Part 1", () -> GiftShop.part1(input)); // 13108371860
        TimingUtils.timeMethodAndReturnAnswerAsLong("Part 2", () -> GiftShop.part2(input)); //
    }
}
