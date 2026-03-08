package y2025.d03;

import java.util.List;

public class Lobby {
    public static int part1(List<String> input) {
        int joltage = 0;

        for (String line : input) {
            joltage += findHighestJoltage(line);
        }

        return joltage;
    }

    private static int findHighestJoltage(String line) {
        int highestJoltage = 0;
        int secondBatteryStartIndex = 0;
        int batteryLength = line.length();

        for (int i = 0; i < batteryLength; i++) {
            boolean isLastDigit = batteryLength == i + 1;
            // arithmic - autopromotes the char to int. the '0' is the arithmic code for 48
            // e.g. arithmic code for '7' = 55
            // so 55 - 48 = 7, this logic only works for chars that are digits 0-9
            int joltage = line.charAt(i) - '0';

            if (joltage > highestJoltage && !isLastDigit) { // if last digit is highest, don't set it as first since we need 2 digits
                highestJoltage = joltage;
                secondBatteryStartIndex = i + 1;
            }
        }

        highestJoltage *= 10; // times 10 so that the second battery joltage is the 2nd digit

        int secondBatteryJoltage = 0;
        for (int i = secondBatteryStartIndex; i < batteryLength; i++) {
            int joltage = line.charAt(i) - '0';

            if (joltage > secondBatteryJoltage) {
                secondBatteryJoltage = joltage;
            }
        }
        highestJoltage += secondBatteryJoltage;

        return highestJoltage;
    }
}
