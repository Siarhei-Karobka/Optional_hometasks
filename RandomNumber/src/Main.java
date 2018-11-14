import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Generate random n-digit number
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Argument should be single and exist from integer numbers(0-9)");
        } else {
            System.out.println(createRandomNumber(convertArgumentToInteger(args[0])));
        }
    }

    public static int convertArgumentToInteger(String arg) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(arg);
        if (!matcher.matches()) {
            throw new NumberFormatException("Argument should consist only of integer numbers (use symbols 0-9)");
        } else {
            return Short.parseShort(arg); // using short to set max amount of digits. (SHRT_MAX = 32767)
            // if use int or long number will be really big
        }
    }

    public static StringBuilder createRandomNumber(int amountOfDigits){
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < amountOfDigits; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb;
    }
}
