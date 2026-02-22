package y2025.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretEntranceTest {

    private static final List<String> TEST_INPUT = List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82");
    private static final List<String> TEST_INPUT_PART_2 = List.of("R1000");

    @Test
    public void testPart1() {
        int result = SecretEntrance.part1(TEST_INPUT);
        assertEquals(3, result);
    }

    @Test
    public void testPart2() {
        int result = SecretEntrance.part2(TEST_INPUT);
        assertEquals(6, result);
    }

    @Test
    public void testPart2SingleStep() {
        int result = SecretEntrance.part2(TEST_INPUT_PART_2);
        assertEquals(10, result);
    }
}
