import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write method, who set circle area with radius X.
 */

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Argument should be single and exist from integer or double (Example: 3 or 3.0");
        } else {
            System.out.println(setCircleArea(convertArgumentToDouble(args[0])));
        }
    }

    public static double convertArgumentToDouble(String arg) {
        Pattern pattern = Pattern.compile("[0-9]+([.][0-9])*");
        Matcher matcher = pattern.matcher(arg);
        if (!matcher.matches()) {
            throw new NumberFormatException("Argument should consist only integer or double numbers (Example: 3 or 3.0");
        } else {
            return Double.parseDouble(arg);
        }
    }

    public static double setCircleArea (double radius){
        return Math.PI * Math.pow(radius,2);
    }
}
