public class Utils {

    public String toRomanDigit(int digit) {
        if (digit < 0) {
            throw new IllegalArgumentException("В римской системе нет отрицательных чисел!");
        } else {
            String[] roman = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I", " "};
            int[] arabian = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1, 0};
            StringBuilder s = new StringBuilder();

            for(int i = 0; digit > 0; i++) {
                while(arabian[i] <= digit) {
                    s.append(roman[i]);
                    digit -= arabian[i];
                }
            }

            return s.toString();
        }
    }

    public int getRomanDigit(String s) {
        return switch (s) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    public int getDigit(String s) {
        try {
            int digit = Integer.parseInt(s);
            return digit > 10 ? 0 : digit;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e + ". Введена некорректная цифра!");
        }
    }
}
