package javamentor.numbers.roman;

import java.util.HashMap;

public class RomanConverter {

    public static HashMap<String, Integer> romanToArabic = new HashMap<>();

    private static final HashMap<Integer, String> arabicToRoman = new HashMap<>();

    public static void convertRomanToArabic() {
        int i = 1;
        for (RomanNumbersEnum number:
                RomanNumbersEnum.values()) {
            romanToArabic.put(number.toString(), i);
            arabicToRoman.put(i, number.toString());
            i++;
        }
        arabicToRoman.put(0, "");
    }

    public static String convertArabicToRoman(final int number) {
        switch (number / 10) {
            case 0:
                return arabicToRoman.get(number);
            case 1:
                return "X" + arabicToRoman.get(number % 10);
            case 2:
                return "XX" + arabicToRoman.get(number % 10);
            case 3:
                return "XXX" + arabicToRoman.get(number % 10);
            case 4:
                return "XL" + arabicToRoman.get(number % 10);
            case 5:
                return "L" + arabicToRoman.get(number % 10);
            case 6:
                return "LX" + arabicToRoman.get(number % 10);
            case 7:
                return "LXX" + arabicToRoman.get(number % 10);
            case 8:
                return "LXXX" + arabicToRoman.get(number % 10);
            case 9:
                return "XC" + arabicToRoman.get(number % 10);
            case 10:
                return "C";
        }
        return "Ответ за границами дозволенного";
    }
}
