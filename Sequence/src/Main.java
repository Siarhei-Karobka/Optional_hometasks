import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write program who's role, check numeral of some number in growing sequence.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Argument should be single, no more than 10 digits, use int numbers (0-9)");
        } else {
            System.out.println("Is sequence growing: " + checkSequence(isArgumentNumber(args)));
        }
    }

    public static boolean checkSequence(String number){
        char[] numberElements = number.toCharArray();
        int[] elements = new int[numberElements.length];

        for (int i = 0; i < elements.length; i++) {
            elements[i] = (int) numberElements[i];
        }

        for (int i = 0; i < elements.length - 1; i++) {
            if (elements[i] >= (elements[i+1])){
                return false;
            }
        }
        return true;
    }

    public static String isArgumentNumber(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(args[0]);
        if (!matcher.matches()) {
            throw new NumberFormatException("Argument should consist only integer numbers (0-9)");
        } else if (args[0].length() > 10){
            throw new NumberFormatException("Argument should be no more than 10 digits");
        } else {
            return args[0];
        }
    }
}
