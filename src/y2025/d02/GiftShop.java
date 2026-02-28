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

    public static long part2(List<String> input) {
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
//            String digitAsString = String.valueOf(digit);
//            int halfDigitLength = digitAsString.length() / 2;
//            String firstHalf = digitAsString.substring(0, halfDigitLength);
//            String secondHalf = digitAsString.substring(halfDigitLength);
//
//            if (firstHalf.equals(secondHalf)) {
//                sum += digit;
//            }

            // this is about 3-5 times faster than the above. Conversion to string gets expensive for large ranges
            if (isInvalidId(digit)) {
                sum += digit;
            }
        }

        return sum;
    }

    private static boolean isInvalidId(long digit) {
//        String digitAsString = String.valueOf(digit);
        String digitAsString = Long.toString(digit);
        int length = digitAsString.length();
        int halfLength = length / 2;

        // can the digit be split into two equal halves? if no skip the digit
        if (length % 2 != 0) {
            return false;
        }

        // for each half, check if the characters are equal, 0 index
        for (int i = 0; i < halfLength; i++) {
            if (digitAsString.charAt(i) != digitAsString.charAt(halfLength + i)) {
                return false;
            }
        }

        return true;
    }
}
