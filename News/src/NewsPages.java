import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * News showed in amount 10 on page. write method, which define amount of pages for N-news
 */
public class NewsPages {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Argument should be single");
        } else {
            System.out.println(getPagesNumber(convertArgumentToInteger(args[0])));
        }
    }

    public static int convertArgumentToInteger(String arg) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(arg);
        if (!matcher.matches()) {
            throw new NumberFormatException("Argument should consist only of integer numbers (use symbols 0-9)");
        } else {
            return Integer.parseInt(arg);
        }
    }

    public static int getPagesNumber(int newsNumber) {

        if (newsNumber < 0) {
            throw new NumberFormatException("Amount of news can't be negative");
        } else if (newsNumber == 0) {
            return 1;
        } else {
            return (int) Math.ceil((double) newsNumber / 10);
        }
    }
}
