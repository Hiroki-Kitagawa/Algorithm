import java.util.Scanner;
import java.util.Random;

class HiAndLow {
  public static Integer numberOfAnswers = 0;

  public static Integer inputNum() {
    System.out.println("数字を入力し、0-100の範囲で当ててください。");
    Scanner scanner = new Scanner(System.in);
    Integer inputNum = Integer.parseInt(scanner.next());
    numberOfAnswers++;
    return inputNum;
  }

  public static Integer randomNum() {
    Random random = new Random();
    Integer randomNum = random.nextInt(100) + 1;
    return randomNum;
  }

  public static void hiAndLow(Integer randomNum) {
    Integer inputNum = inputNum();
    if (inputNum < randomNum) {
      System.out.println("もっと上");
      hiAndLow(randomNum);
    } else if (inputNum > randomNum) {
      System.out.println("もっと下");
      hiAndLow(randomNum);
    } else {
      System.out.println("正解！・・・" + numberOfAnswers +"回で当てました");
    }
  }

  public static void main(String[] args) {
    Integer randomNum = randomNum();
    hiAndLow(randomNum);
  }
}
