import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class StringHash {
  public static List<String> outputWords = new ArrayList<String>();

  public static void displayWords() {
    System.out.println("{" + String.join(", ", outputWords) + "}");
  }

  public static void editWords(List<String> words) {
    outputWords.add(words.get(0) + " : " + words.size());
  }

  public static void findWord(List<String> words) {
    List<String> foundWord = new ArrayList<String>();
    for (String word : words) {
      if (word.equals(words.get(0))) {
        foundWord.add(word);
      }
    }
    editWords(foundWord);
    words.removeAll(foundWord);
    if (words.size() > 0) {
      findWord(words);
    }
  }

  public static List<String> inputWords() {
    System.out.println("文字列を入力してください。文字列に含まれる単語ごとに単語数を数えます。");
    Scanner scanner = new Scanner(System.in);
    String inputs = scanner.nextLine();
    List<String> words = new ArrayList<String>(Arrays.asList(inputs.split(" ")));
    return words;
  }

  public static void main(String[] args) {
    findWord(inputWords());
    displayWords();
  }
}
