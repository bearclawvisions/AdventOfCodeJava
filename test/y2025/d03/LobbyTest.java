package y2025.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LobbyTest {
    private static final List<String> TEST_INPUT = List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111");

    @Test
    public void testPart1() {
        int result = Lobby.part1(TEST_INPUT);
        assertEquals(357, result);
    }
}
