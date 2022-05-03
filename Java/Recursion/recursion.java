import java.util.Scanner;

class Recursion {
  private static Integer sum = 0;

  private static Integer sum(Integer inputnum) {
    sum += inputnum;
    if (inputnum > 0) {
      sum(inputnum - 1);
    } else if (inputnum < 0) {
      sum(inputnum + 1);
    }
    return sum;
  }

  private static Integer userInputNum() {
    System.out.println("数字を入力してください。入力値から0まで合計した値を表示します。");
    Scanner inputnum = new Scanner(System.in);
    return Integer.parseInt(inputnum.next());
  }
  public static void main(String[] args) {
    System.out.println(sum(userInputNum()));
  }
}
