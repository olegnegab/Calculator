import java.util.*;

public class Main {
    private static final Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
    }

    public static void main(String[] args) {
        try {
            calc(new Scanner(System.in).nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calcGr(String[] symbols) throws Exception {
        int num1 = Integer.parseInt(symbols[0]);
        int num2 = Integer.parseInt(symbols[2]);
        int result;
        if (num1 > 10 || num1 < 0 || num2 > 10 || num2 < 0) {
            throw new Exception("Число должно быть больше 1 и меньше 10");
        }
        switch (symbols[1]) {
            case "+":
                result = (num1 + num2);
                break;
            case "-":
                result = (num1 - num2);
                break;
            case "/":
                result = (num1 / num2);
                break;
            case "*":
                result = (num1 * num2);
                break;
            default:
                throw new Exception("Строка не является математической операцией");
        }
        return String.valueOf(result);
    }

    public static String calcRim(String[] symbols) throws Exception {

        int result;
        int num1 = map.get(symbols[0]);
        int num2 = map.get(symbols[2]);
        if (num1 > 10 || num1 < 0 || num2 > 10 || num2 < 0) {
            throw new Exception("Число должно быть больше 1 и меньше 10");
        }
        switch (symbols[1]) {
            case "+":
                result = (num1 + num2);
                break;
            case "-":
                if (num1 < num2) {
                    throw new Exception("В римской системе нет отрицательных чисел");
                }
                result = (num1 - num2);
                break;
            case "/":
                result = (num1 / num2);
                break;
            case "*":
                result = (num1 * num2);
                break;
            default:
                throw new Exception("Строка не является математической операцией");
        }
        String answer = "Результат вычисления находится вне пределов";
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            if (x.getValue() == result) {
                answer = x.getKey();
            }
        }
        return answer;
    }

    public static void calc(String args) throws Exception {
        String[] symbols = args.split(" ");
        String[] strings = validate(symbols);
        String regex = "[-+]?\\d+";
        if (strings[0].matches(regex) && strings[2].matches(regex)) {
                System.out.println(calcGr(symbols));
        }
        else {
                System.out.println(calcRim(symbols));
        }
    }

    private static String[] validate(String[] strings) throws Exception {
        if (strings.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию");
        }
        if (strings.length < 3) {
            throw new Exception("Строка не является математической операцией");
        }

        boolean containsKeyInMap1 = map.containsKey(strings[0]);
        boolean containsKeyInMap2 = map.containsKey(strings[2]);
        String regex = "[-+]?\\d+";
        if ((containsKeyInMap1 || containsKeyInMap2) && (strings[0].matches(regex) || strings[2].matches(regex))) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        return strings;
    }
}







