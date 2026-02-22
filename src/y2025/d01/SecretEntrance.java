package y2025.d01;

import java.util.List;

public class SecretEntrance {
    private final static String LEFT = "L";
    private final static int DIAL_MIN = 0;
    private final static int DIAL_MAX = 99;
    private final static int DIAL_TICKS = 100;

    public static int part1(List<String> input) {
        int dialPosition = 50;
        int zeroCount = 0;

        for (String line : input) {
            int rotation = parseRotation(line);
            dialPosition = calculateNewPosition(dialPosition, rotation);

            if (dialPosition == DIAL_MIN) {
                zeroCount++;
            }
        }

        return zeroCount;
    }

    public static int part2(List<String> input) {
        int dialPosition = 50;
        int zeroCount = 0;

        for (String line : input) {
            int rotation = parseRotation(line);
            dialPosition += rotation;
            zeroCount += calculateZerosPassed(dialPosition, rotation);
            dialPosition = Math.floorMod(dialPosition, DIAL_TICKS);
        }

        return zeroCount;
    }

    private static int calculateNewPosition(int dialPosition, int rotation) {
        int newPosition = dialPosition + rotation;

        if (newPosition > DIAL_MAX) { // only possible when turning clockwise
            int diff = newPosition - DIAL_TICKS; // -1 adjust for the 0, since it physically counts as a tick
            return DIAL_MIN + diff;
        } else if (newPosition < DIAL_MIN) { // only possible when turning counterclockwise
            newPosition *= -1; // adjust for negative
            return DIAL_TICKS - newPosition; // +1 adjust for the 0, since it physically counts as a tick
        }

        return newPosition;
    }

    private static int parseRotation(String line) {
        String direction = line.substring(0, 1);
        int distance = Integer.parseInt(line.substring(1));

        if (direction.equals(LEFT)) {
            distance *= -1; // turn to the left / counterclockwise
        }

        return distance;
    }

    private static int calculateZerosPassed(int newPosition, int rotation) {
        if (rotation > 0) {
            return newPosition / DIAL_TICKS;
        } else {
            int zerosPassed = (DIAL_TICKS - newPosition) / DIAL_TICKS;

            boolean startedAtZero = newPosition - rotation == 0;
            if (startedAtZero) {
                zerosPassed--;
            }

            return zerosPassed;
        }
    }
}
