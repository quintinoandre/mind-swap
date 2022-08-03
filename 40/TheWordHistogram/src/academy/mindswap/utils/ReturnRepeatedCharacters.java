package academy.mindswap.utils;

import java.util.stream.IntStream;

public final class ReturnRepeatedCharacters {
    private ReturnRepeatedCharacters() {
    }

    public static String returnRepeatedCharacters(String characterBar, int times) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, times).forEach(item -> stringBuilder.append(characterBar));

        return stringBuilder.toString();
    }
}
