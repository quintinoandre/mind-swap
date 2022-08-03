package academy.mindswap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static academy.mindswap.utils.ReturnRepeatedCharacters.returnRepeatedCharacters;

public class WordHistogram implements Iterable<String> {

    private Map<String, Integer> map;
    private int largestWordSize = 0;

    public WordHistogram() {
        map = new HashMap<>();
    }

    public Map<String, Integer> analyseString(String stringToAnalyse) {
        map = new HashMap<>();

        List<String> list = List.of(stringToAnalyse.toLowerCase().replaceAll("\\W\\s'", "")
                .replaceAll("\\s+", " ")
                .split(" "));

        for (String word : list) {
            largestWordSize = Math.max(word.length(), largestWordSize);

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);

                continue;
            }

            map.put(word, 1);
        }

        return map;
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

        map.forEach((k, v) -> stringBuilder.append(k)
                .append(returnRepeatedCharacters(" ", largestWordSize - k.length()))
                .append(" : ")
                .append(returnRepeatedCharacters("[]", v))
                .append("\n"));

        return stringBuilder.toString();
    }
}
