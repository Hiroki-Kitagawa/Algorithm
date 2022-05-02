import java.util.Scanner;
import java.util.Random;

class Janken {
  private static final String JANKEN_HANDS[] = {"グー", "チョキ", "パー"};

  private static void judgeJanken(Integer usersHand, Integer computersHand) {
    if (usersHand == 0 && computersHand == 0 ||
        usersHand == 1 && computersHand == 1 ||
        usersHand == 2 && computersHand == 2) {
          System.out.println("「アイコでしょ！」");
          startJanken();
    } else if (usersHand == 0 && computersHand == 1 ||
               usersHand == 1 && computersHand == 2 ||
               usersHand == 2 && computersHand == 0) {
                System.out.println("「あなたの勝ち！」");
    }else {
      System.out.println("「コンピューターの勝ち！」");
    }
  }

  private static Integer usersHand() {
    Scanner usersInput = new Scanner(System.in);
    return Integer.parseInt(usersInput.next());
  }

  private static Integer computersHand() {
    Random random = new Random();
    return random.nextInt(3);
  }

  private static void startJanken() {
    System.out.println("じゃんけん・・・");
    System.out.println("> 0.グー 1.チョキ 2.パー");

    Integer usersHand = usersHand();
    Integer computersHand = computersHand();

    System.out.println("「ぽい！」");
    System.out.println("*コンピューター : " + JANKEN_HANDS[computersHand]);
    System.out.println("*あなた         : " + JANKEN_HANDS[usersHand]);
    judgeJanken(usersHand, computersHand);
  }

  public static void main(String[] args) {
    startJanken();
  }
}
