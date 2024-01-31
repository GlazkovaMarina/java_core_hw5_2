import java.nio.charset.Charset;
import java.util.Locale;
import java.util.OptionalInt;
import java.util.Scanner;

public class App{
    static final Locale LOCALE = Locale.forLanguageTag("RU");
    static final Charset CHARSET = Charset.defaultCharset();
    static final Scanner scanner = new Scanner(UncloseableInputStream.wrap(System.in), CHARSET);
    static final int DIM = 3;
    public static void main(String[] args) throws Exception {
        Locale.setDefault(LOCALE);
        final String title = "Игра Крестики-Нолики. Добро пожаловать!";
        final String frame = "\u2550".repeat(title.length());
        System.out.println(frame);
        System.out.println(title);
        System.out.println(frame);
        OptionalInt difficultyOpt = ConsoleUtils.askInteger(scanner,
                "Задайте уровень сложности"
                        + "\n\t0 \u2014 лёгкий,\n\t1 \u2014 сложный"
                        + "\n\t(пустой ввод чтобы завершить приложение)\n?: ",
                0, 1);
        if (difficultyOpt.isEmpty()) {
            exit();
        }
        var difficulty = difficultyOpt.getAsInt() == 0 ? Difficulty.EASY : Difficulty.HARD;
        var game = new Game(scanner, DIM, difficulty);
        game.run();
    }
    private static void exit(){
        System.out.println("\nВы завершили приложение.");
        ConsoleUtils.waitToProceed(scanner);
        System.exit(0);
    }
}