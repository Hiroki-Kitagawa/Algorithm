import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class HitAndBlow {
  public static List<Integer> rand4digits = new ArrayList<Integer>();
  public static List<Integer> convertInputNum = new ArrayList<Integer>();
  public static Integer numberOfAnswers = 0;
  public static Integer hits = 0;
  public static Integer blow = 0;

  public static void judgeHitAndBlow(List<String> inputNums) {
    if (inputNums.size() > 4 || inputNums.size() < 4) {
      inputNum();
    } else {
      numberOfAnswers++;
      convertInputNum = inputNums.stream().map(num -> Integer.parseInt(num)).collect(Collectors.toList());
      if (convertInputNum.equals(rand4digits)) {
        System.out.println(numberOfAnswers + "回で正解！");
      } else {
        IntStream.range(0, rand4digits.size()).forEach(hitsIdx -> {
          if (rand4digits.get(hitsIdx) == convertInputNum.get(hitsIdx)) {
            hits += 1;
          }
          IntStream.range(0, convertInputNum.size()).forEach(blowIndex -> {
            if (rand4digits.get(hitsIdx) == convertInputNum.get(blowIndex) && hitsIdx != blowIndex) {
              blow += 1;
            }
          });
        });
        System.out.println("外れ： " + hits + "Hits" + blow + "Blow");
        hits = 0;
        blow = 0;
        inputNum();
      }
    }
  }

  public static void inputNum() {
    System.out.println("各桁が異なる4桁の数字を入力してください。");
    Scanner scanner = new Scanner(System.in);
    String inputNum = scanner.next();
    List<String> inputNums = new ArrayList<String>(Arrays.asList(inputNum.split("")));
    judgeHitAndBlow(inputNums);
  }

  public static Integer randNum() {
    Random random = new Random();
    Integer randNum = random.nextInt(10);
    return randNum;
  }

  public static void rand4digits() {
    Integer randNum = randNum();
    if (rand4digits.size() == 0) {
      rand4digits.add(randNum);
    }
    while (rand4digits.size() < 4) {
      IntStream.range(0, rand4digits.size()).forEach(idx -> {
        if (rand4digits.size() - 1 == idx &&
            rand4digits.get(idx) != randNum) {
              rand4digits.add(randNum);
              rand4digits();
        } else if (rand4digits.get(idx) == randNum) {
          rand4digits();
        } else {
          // 数字が重複しない、かつ最後の桁まで処理が完了していない場合、何もしない
        }
      });
    }
  }

  public static void main(String[] args) {
    rand4digits();
    inputNum();
  }
}
