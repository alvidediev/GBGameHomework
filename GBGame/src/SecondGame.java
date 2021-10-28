import java.util.Random;
import java.util.Scanner;

public class SecondGame {
    static Random random = new Random();
    private final static int ARRAY = 3;
    private final static int FIND_ME = 1;

    public static void gameStarter() throws InterruptedException {
        System.out.println("Что же, похоже вы настроены серьезно, но и мы не собираемся сдаваться");
        Thread.sleep(3000);
        System.out.println("Чтобы дальше попытаться уйти от нас Вам придется угадать под какой ячейкой находится число.");
        Thread.sleep(4000);
        System.out.println("У вас только 3 попытки!");
        Thread.sleep(4000);
        System.out.println("Помните, вводите строго координаты ячеек!");
        Thread.sleep(4000);
        int[][] board = fillGameField();
        game(board);
    }

    public static void game(int[][] board) {
        int counter = 2;
        for (; ; ) {
            printGameField(board);
            System.out.print("Введите координаты: ");
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            int row = string.charAt(0) - 'A';
            int line = string.charAt(1) - '0';
            if (row < 0 || row >= ARRAY || line < 0 || line >= ARRAY) {
                System.out.println("Введите координаты в пределах доски!");
            } else if (board[line][row] == FIND_ME) {
                System.out.println("Вы выиграли, но вы все равно остаетесь с нами! :)");
                break;
            } else {
                System.out.println("Не судьба. Осталось попыток " + counter);
                counter--;

            }
            if (counter < 0) {
                System.out.println("Вы проиграли и остаетесь с нами!");
                break;
            }
        }
    }


    public static void printGameField(int[][] board) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + ARRAY; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < ARRAY; i++) {
            System.out.printf("%3d ", i);
            for (int j = 0; j < ARRAY; j++) {
                if (board[i][j] == 0 || board[i][j] == FIND_ME) {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }
    }


    public static int[][] fillGameField() {
        int[][] gameField = new int[ARRAY][ARRAY];
        for (int i = 0; i < ARRAY; i++) {
            gameField[i][i] = 0;
        }
        gameField[random.nextInt(ARRAY)][random.nextInt(ARRAY)] = FIND_ME;
        return gameField;
    }
}