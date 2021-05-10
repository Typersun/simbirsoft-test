package typersun;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Counter {

    /// Разделителем является все то, что не является буквами алфавита
    public static String[] parseWords(String text) {
        return text.toUpperCase().split("[^a-zA-Zа-яА-я]+");
    }

    public static void printResult(String[] words) {
        Arrays.stream(words)
                .filter(s -> s.equals("") == false)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> System.out.println(k + " " + v.size()));
    }
}
