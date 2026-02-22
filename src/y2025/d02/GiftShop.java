package y2025.d02;

import java.util.List;

public class GiftShop {

    public static long part1(List<String> input) {
        String inputAsLine = input.getFirst(); // there is only one line
        List<String> idRanges = List.of(inputAsLine.split(","));
        long sum = 0;

        for (String idRange : idRanges) {
            String[] range = idRange.split("-");
            long min = Long.parseLong(range[0]);
            long max = Long.parseLong(range[1]);

            sum += FindInvalidIds(min, max);
        }

        return sum;
    }

    private static long FindInvalidIds(long min, long max) {
        long sum = 0;

        for (long digit = min; digit <= max; digit++) {
            sum += FindDuplicateDigits(digit);
        }

        return sum;
    }

    private static long FindDuplicateDigits(long digit) {
        String digitAsString = String.valueOf(digit);
        int halfDigitLength = digitAsString.length() / 2;
        String firstHalf = digitAsString.substring(0, halfDigitLength);
        String secondHalf = digitAsString.substring(halfDigitLength);

        if (firstHalf.equals(secondHalf)) {
            return digit;
        }

        return 0;
    }
}
