package cryptoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cryptographer {
    public static final List<Character> ALPHABET = List.of('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');

    private static final Map<Character, Integer> ALPHABET_MAP = ALPHABET.stream()
            .collect(Collectors.toMap(k -> k, v -> ALPHABET.indexOf(v)));
    private static final int ALPHABET_LEN = ALPHABET.size();

    public static List<Character> encrypt(List<Character> text, int key) {
        return crypt(text, key, 1);
    }

    public static List<Character> decrypt(List<Character> text, int key) {
        return crypt(text, key, -1);
    }

    public static List<Character> crypt(List<Character> text, int key, int factor) {
        List<Character> res = new ArrayList<>();
        for (var symbol : text) {
            if (!ALPHABET_MAP.containsKey(symbol)) {
                continue;
            }
            int indexFirst = ALPHABET_MAP.get(symbol);
            int indexSecond = (indexFirst + key * factor) % ALPHABET_LEN;
            if (indexSecond < 0) {
                indexSecond = ALPHABET_LEN + indexSecond;
            }
            res.add(ALPHABET.get(indexSecond));
        }
        return res;
    }
}
