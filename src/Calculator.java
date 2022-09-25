import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    Utils utils = new Utils();

    public Calculator() {
    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print("Введите выражение: ");
            this.parseExpression(reader.readLine());
            System.out.print("Хотите продолжить? (введите 'ex' - для выхода) ");
        } while(!reader.readLine().equals("ex"));

    }

    private boolean calculate(int a, int b, String operation, boolean arabian) {
        int res;
        switch (operation) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
            default:
                return false;
        }

        if (arabian) {
            System.out.println(res);
        } else {
            System.out.println(this.utils.toRomanDigit(res));
        }

        return true;
    }

    private void parseExpression(String input) {
        String[] s = input.split(" ");
        if (s.length == 3 && s[1].length() == 1) {
            boolean arabian = false;
            int a = this.utils.getRomanDigit(s[0]);
            int b;
            if (a == 0) {
                arabian = true;
                a = this.utils.getDigit(s[0]);
                b = this.utils.getDigit(s[2]);
            } else {
                b = this.utils.getRomanDigit(s[2]);
            }

            if (a > 0 && b > 0) {
                if (!this.calculate(a, b, s[1], arabian)) {
                    throw new IllegalArgumentException("Неверная операция!");
                }
            } else {
                throw new IllegalArgumentException("Цифры не соответствуют условиям!");
            }
        } else {
            throw new IllegalArgumentException("Неверное выражение!");
        }
    }
}
