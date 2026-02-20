package y2025.d01;

import java.util.List;

public class SecretEntrance {
    private record RotationResult(int distance, int zerosPassed) {}
    private record PositionResult(int newPosition, int zerosPassed) {}

    private final static String LEFT = "L";
    private final static int DIAL_MIN = 0;
    private final static int DIAL_MAX = 99;
    private final static int DIAL_TICKS = 100;

    public static int part1(List<String> input) {
        int dialPosition = 50;
        int zeroCount = 0;

        for (String line : input) {
            int rotation = parseRotation(line).distance;
            dialPosition = calculateNewPosition(dialPosition, rotation).newPosition;

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
            RotationResult rotationResult = parseRotation(line);
            int rotation = rotationResult.distance;
            zeroCount += rotationResult.zerosPassed;

            PositionResult positionResult = calculateNewPosition(dialPosition, rotation);
            dialPosition = positionResult.newPosition;
            zeroCount += positionResult.zerosPassed;

//            if (dialPosition == DIAL_MIN) {
//                zeroCount++;
//            }
        }

        return zeroCount;
    }

    private static PositionResult calculateNewPosition(int dialPosition, int rotation) {
        int newPosition = dialPosition + rotation;
        int zerosPassed = 0;

        if (newPosition > DIAL_MAX) { // only possible when turning clockwise
            int diff = newPosition - DIAL_TICKS; // -1 adjust for the 0, since it physically counts as a tick
            zerosPassed++;
            return new PositionResult(DIAL_MIN + diff, zerosPassed);
        } else if (newPosition < DIAL_MIN) { // only possible when turning counterclockwise
            newPosition *= -1; // adjust for negative
            zerosPassed++;
            return new PositionResult(DIAL_TICKS - newPosition, zerosPassed); // +1 adjust for the 0, since it physically counts as a tick
        }

        return new PositionResult(newPosition, zerosPassed);
    }

    private static RotationResult parseRotation(String line) {
        String direction = line.substring(0, 1);
        int distance = Integer.parseInt(line.substring(1));
        int zerosPassed = distance / DIAL_TICKS;

        if (distance > DIAL_MAX) {
            distance = distance % DIAL_TICKS;
        }

        if (direction.equals(LEFT)) {
            distance *= -1; // turn to the left / counterclockwise
        }

        return new RotationResult(distance, zerosPassed);
    }

}
