import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //System.out.println(validateCB("4242424242424242"));
        System.out.println(validateCB("5356810197874515"));
    }

    public static boolean validateCB(String cbNumber)
    {
        if (cbNumber.length() != 16) {
            return false;
        }

        String[] splitted = cbNumber.split("");
        System.out.println(Arrays.toString(splitted));

        int[] handled = new int[16];

        for (int i=0; i<splitted.length; i++) {
            int number = Integer.parseInt(splitted[i]);
            if (i%2 == 0) {
                int doubleX = number*2;
                doubleX = number == 9 ? 9 : doubleX%9;
                handled[i] = doubleX;
            } else {
                handled[i] = number;
            }
        }

        int sum = IntStream.of(handled).sum();

        return sum % 10 == 0;
    }
}