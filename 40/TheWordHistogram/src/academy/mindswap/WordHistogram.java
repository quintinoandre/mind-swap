package academy.mindswap;

import academy.mindswap.utils.Colors;

import java.util.*;

import static academy.mindswap.utils.Colors.RESET;
import static academy.mindswap.utils.ReturnRepeatedCharacters.returnRepeatedCharacters;

public class WordHistogram implements Iterable<String> {

    private Map<String, Integer> map;
    private int largestWordSize = 0;

    public WordHistogram() {
        map = new HashMap<>();
    }

    private Map<String, Integer> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<String, Integer> m = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> item : list) {
            m.put(item.getKey(), item.getValue());
        }

        return m;
    }

    public void analyseString(String stringToAnalyse) {
        map = new HashMap<>();

        List<String> list = List.of(stringToAnalyse.toLowerCase()
                .replaceAll("[.,;]", "")
                .trim()
                .replaceAll(" +", " ")
                .split(" "));

        for (String word : list) {
            largestWordSize = Math.max(word.length(), largestWordSize);

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);

                continue;
            }

            map.put(word, 1);
        }
    }

    public int get(String word) {
        return map.get(word);
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Colors[] colors = Colors.values();

        sortMapByValue(map).forEach((k, v) -> {
            Colors randomColor = colors[(int) (Math.random() * colors.length - 1)];

            stringBuilder.append(k)
                    .append(returnRepeatedCharacters(" ", largestWordSize - k.length()))
                    .append(" : ")
                    .append("(")
                    .append(v)
                    .append(") ")
                    .append(returnRepeatedCharacters(randomColor.getBackgroundColorCode() + " "
                            + RESET.getBackgroundColorCode(), v))
                    .append("\n");
        });

        return stringBuilder.toString();
    }
}
