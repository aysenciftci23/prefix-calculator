import java.util.Scanner;

public class Main {

    public static boolean rakam(String character) {
        try {
            Integer.parseInt(character);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }}

    public static <T extends Comparable> Double postfixCalculate(String str) throws Exception {
        double result = 0;
        String tempNumber;
        GenericStack<Double> tempStack = new GenericStack<>(Double.class, str.length());

        for (int i = 0; i < str.length(); i++) {
            String tut = String.valueOf(str.charAt(i));
            if (tut.compareTo("_") == 0) {
                continue;
            }
            if (rakam(tut) == true) {
                tempNumber = "";
                while (rakam(String.valueOf(str.charAt(i))) == true) {
                    tut = String.valueOf(str.charAt(i));
                    tempNumber += tut;
                    i++;
                }
                    tempStack.push(Double.valueOf(tempNumber));
                    i--;
            } else {
                if (tempStack.size() < 2) {
                    System.out.println("Yetersiz eleman.");
                }
                double sayi2 = tempStack.pop();
                double sayi1 = tempStack.pop();

                switch (tut) {
                    case "+":
                        result = sayi1 + sayi2;
                        break;
                    case "-":
                        result = sayi1 - sayi2;
                        break;
                    case "*":
                        result = sayi1 * sayi2;
                        break;
                    case "/":
                        if (sayi2 == 0) {
                            System.out.println("Geçersiz eleman,bölen sıfıra eşit olamaz.");
                        }
                        result = sayi1 / sayi2;
                        break;
                    default:
                        throw new Exception("Geçersiz eleman.");
                }
                tempStack.push(result);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("postfix bir ifade giriniz:");
        String postfix = scanner.next();
        try{
        System.out.println("Sonuç: "+postfixCalculate(postfix));}
        catch (Exception e){
            System.out.println("Hata: "+e.getMessage());
        }

    }
}