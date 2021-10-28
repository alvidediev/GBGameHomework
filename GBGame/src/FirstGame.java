import java.util.Random;
import java.util.Scanner;

public class FirstGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int count = 3;

    public static void startGame() throws InterruptedException {
        System.out.println("И так, Сергей, Вы тут...");
        Thread.sleep(5000);
        System.out.println("Слышал Вы хотите нас покинуть...");
        Thread.sleep(5000);
        System.out.println("Что ж, если Вы хотите нас покинуть, то сперва Вам придется сыграть в маленькую игру! :)");
        Thread.sleep(3000);
        System.out.println("Скажите, Сенсей, встречали ли вы таких идеальных студентов как мы ?");
        Thread.sleep(3000);
        senseysFirstAnswer();
    }

    public static void senseysFirstAnswer() throws InterruptedException {
        for (; ; ) {
            System.out.print("Введите Да или Нет: ");
            String answer = scanner.nextLine();
            if (answer.equals("Да")) {
                count--;
                randomWordsArray();
                if (count == 0) {
                    Thread.sleep(4000);
                    SecondGame.gameStarter();
                    break;
                }
            } else if (answer.equals("Нет")) {
                System.out.println("Мы так и знали!");
                break;
            } else {
                System.out.println("Введите только Да или Нет!");
            }
        }
    }

    public static String randomWordsArray() {
        String[] string = {"Как это да ?!", "Упс...где то в далеке зазвучали сирены...бегите, Вы взломали Пентагон!",
                "А может все таки нет?",
                "System error - перезапускаем программу",
                "И вы выигрываете автомобииииль! Шутка ;) неправильный ответ",
                "ʕ ᵔᴥᵔ ʔ"};
        String a = string[Integer.parseInt(Integer.toString(random.nextInt(6)))];
        System.out.println(a);
        return a;
    }
}
