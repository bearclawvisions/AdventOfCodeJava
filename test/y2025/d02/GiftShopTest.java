package y2025.d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiftShopTest {
    private static final List<String> TEST_INPUT = List.of(
            "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
    );

    @Test
    public void testPart1() {
        long result = GiftShop.part1(TEST_INPUT);
        assertEquals(1227775554L, result);
    }

    @Test
    public void testPart2() {
        long result = GiftShop.part2(TEST_INPUT);
        assertEquals(4174379265L, result);
    }
}
