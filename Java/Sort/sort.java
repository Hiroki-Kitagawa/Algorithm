import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Sort {
  private static final List<Integer> sortNumbers = new ArrayList<Integer>(Arrays.asList(20, 31, 42, 13, 5, 38));
  private static List<Integer> quickSorting = new ArrayList<Integer>();
  private static List<String> quickSorted = new ArrayList<String>();

  private static Integer bubbleSortTimes(Integer numbersSize) {
    return (numbersSize * (numbersSize - 1) / 2);
  }

  private static List<String> descBubbleSort(List<Integer> numbers) {
    Integer numbersSize = numbers.size();
    Integer bubbleSortTimes = bubbleSortTimes(numbersSize);
    IntStream.range(0, bubbleSortTimes).forEach(sortTimes -> {
      IntStream.range(0, numbersSize - 1).forEach(idx -> {
        if (numbers.get(idx) < numbers.get(idx + 1)) {
          Integer moveElement = numbers.get(idx);
          numbers.set(idx, numbers.get(idx + 1));
          numbers.set(idx + 1, moveElement);
        }
      });
    });
    List<String> bubbleSorted = numbers
                                .stream()
                                .map(sortedElements -> sortedElements.toString())
                                .collect(Collectors.toList());
    return bubbleSorted;
  }

  private static List<String> ascQuickSort(List<Integer> numbers) {
    Integer numbersSize = numbers.size();
    if (numbersSize < 1) {
      return quickSorted;
    }
    Integer center_pivot = numbers.get(0);
    List<Integer> left_pivot = new ArrayList<Integer>();
    List<Integer> right_pivot = new ArrayList<Integer>();

    IntStream.range(0, numbersSize - 1).forEach(idx -> {
      if (center_pivot > numbers.get(idx + 1)) {
        left_pivot.add(numbers.get(idx + 1));
      } else {
        right_pivot.add(numbers.get(idx + 1));
      }
    });
    ascQuickSort(left_pivot);
    quickSorting.add(center_pivot);
    ascQuickSort(right_pivot);
    quickSorted = quickSorting
                  .stream()
                  .map(i -> i.toString())
                  .collect(Collectors.toList());
    return quickSorted;
  }
  public static void main(String[] args) {
    List<String> descBubbleSort = descBubbleSort(sortNumbers);
    List<String> ascQuickSort = ascQuickSort(sortNumbers);
    System.out.println("合計     : " + Sum.sum(sortNumbers));
    System.out.println("平均     : " + Ave.ave(sortNumbers));
    System.out.println("最大値   : " + descBubbleSort.get(0));
    System.out.println("最小値   : " + ascQuickSort.get(0));
    System.out.println("小さい順 : " + String.join(", ", ascQuickSort));
    System.out.println("大きい順 : " + String.join(", ", descBubbleSort));
  }
}

class Sum {
  public static Integer sum(List<Integer> numbers) {
    Integer sum = 0;
    for (Integer number : numbers) {
      sum += number;
    }
    return sum;
  }
}

class Ave {
  public static Integer ave(List<Integer> numbers) {
    Integer ave = (Sum.sum(numbers) / numbers.size());
    return ave;
  }
}
