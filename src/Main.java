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
        map.put("XI", 11);
        map.put("XII", 12);
        map.put("XIII", 13);
        map.put("XIV", 14);
        map.put("XV", 15);
        map.put("XVI", 16);
        map.put("XVII", 17);
        map.put("XVIII", 18);
        map.put("XIX", 19);
        map.put("XX", 20);
        map.put("XXI", 21);
        map.put("XXII", 22);
        map.put("XXIII", 23);
        map.put("XXIV", 24);
        map.put("XXV", 25);
        map.put("XXVI", 26);
        map.put("XXVII", 27);
        map.put("XXVIII", 28);
        map.put("XXIX", 29);
        map.put("XXX", 30);
        map.put("XXXI", 31);
        map.put("XXXII", 32);
        map.put("XXXIII", 33);
        map.put("XXXIV", 34);
        map.put("XXXV", 35);
        map.put("XXXVI", 36);
        map.put("XXXVII", 37);
        map.put("XXXVIII", 38);
        map.put("XXXIX", 39);
        map.put("XXXX", 40);
        map.put("XXXXI", 41);
        map.put("XXXXII", 42);
        map.put("XXXXIII", 43);
        map.put("XXXXIV", 44);
        map.put("XXXXV", 45);
        map.put("XXXXVI", 46);
        map.put("XXXXVII", 47);
        map.put("XXXXVIII", 48);
        map.put("XXXXIX", 49);
        map.put("L", 50);
        map.put("LI", 51);
        map.put("LII", 52);
        map.put("LIII", 53);
        map.put("LIV", 54);
        map.put("LV", 55);
        map.put("LVI", 56);
        map.put("LVII", 57);
        map.put("LVIII", 58);
        map.put("LIX", 59);
        map.put("LX", 60);
        map.put("LXI", 61);
        map.put("LXII", 62);
        map.put("LXIII", 63);
        map.put("LXIV", 64);
        map.put("LXV", 65);
        map.put("LXVI", 66);
        map.put("LXVII", 67);
        map.put("LXVIII", 68);
        map.put("LXIX", 69);
        map.put("LXX", 70);
        map.put("LXXI", 71);
        map.put("LXXII", 72);
        map.put("LXXIII", 73);
        map.put("LXXIV", 74);
        map.put("LXXV", 75);
        map.put("LXXVI", 76);
        map.put("LXXVII", 77);
        map.put("LXXVIII", 78);
        map.put("LXXIX", 79);
        map.put("LXXX", 80);
        map.put("LXXXI", 81);
        map.put("LXXXII", 82);
        map.put("LXXXIII", 83);
        map.put("LXXXIV", 84);
        map.put("LXXXV", 85);
        map.put("LXXXVI", 86);
        map.put("LXXXVII", 87);
        map.put("LXXXVIII", 88);
        map.put("LXXXIX", 89);
        map.put("LXXXX", 90);
        map.put("LXXXXI", 91);
        map.put("LXXXXII", 92);
        map.put("LXXXXIII", 93);
        map.put("LXXXXIV", 94);
        map.put("LXXXXV", 95);
        map.put("LXXXXVI", 96);
        map.put("LXXXXVII", 97);
        map.put("LXXXXVIII", 98);
        map.put("LXXXXIX", 99);
        map.put("C", 100);
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







