import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Калькулятор.\n");
        System.out.println("Поддерживается ввод арабских и римских цифр от 1 до 10");
        System.out.println("В одном выражении используйте цифры одной системы счисления, а также операции +,-,*,/");
        System.out.println("Например 2 + 5 или X / V\n");
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
