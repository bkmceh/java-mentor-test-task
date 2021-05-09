package javamentor.numbers.roman;

import java.util.HashMap;

public class RomanConverter {

    public static HashMap<String, Integer> romanToArabic = new HashMap<>();

    public static void convertRomanToArabic() {
        int i = 1;
        for (RomanNumbersEnum number:
                RomanNumbersEnum.values()) {
            romanToArabic.put(number.toString(), i);
            i++;
        }
    }
}
