import java.util.Scanner;

class FizzBuzz {
  private static String fizzBuzz(Integer inputnum) {
    String fizzBuzz;
    if (inputnum % 15 == 0) {
      fizzBuzz = "FizzBuzz";
    } else if (inputnum % 3 == 0) {
      fizzBuzz = "Fizz";
    } else if (inputnum % 5 == 0) {
      fizzBuzz = "Buzz";
    } else {
      fizzBuzz = Integer.toString(inputnum);
    }
    return fizzBuzz;
  }

  private static void displayFizzBuzz(Integer inputnum) {
    for (int i = 1; i <= inputnum; i++) {
      System.out.print(i == inputnum ? fizzBuzz(i) : fizzBuzz(i) + ", ");
    }
  }

  private static Integer inputNum() {
    System.out.println("数字を入力してください");
    Scanner inputnum = new Scanner(System.in);
    return Integer.parseInt(inputnum.next());
  }

  public static void main(String[] args) {
    Integer inputnum = inputNum();
    displayFizzBuzz(inputnum);
  }
}
