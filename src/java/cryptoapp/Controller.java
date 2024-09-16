package cryptoapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public static Context getContext(String cryptoMethod, String pathFrom, String pathTo, String key) {
        ArrayList<String> errorsList = Validator.validate(cryptoMethod, pathFrom, pathTo, key);
        if (errorsList.isEmpty()) {
            return new Context(cryptoMethod, pathFrom, pathTo, Integer.parseInt(key), true, null);
        }
        return new Context(CryptoMethod.UNKNOWN.toString(), pathFrom, pathTo, -1, false, errorsList);
    }

    public void process(Context context) {
        try (
                BufferedReader reader = Files.newBufferedReader(Path.of(context.getFileInput()));
                BufferedWriter writer = Files.newBufferedWriter(Path.of(context.getFileOutput()))) {
            while (reader.ready()) {
                String line = reader.readLine().toLowerCase();
                List<Character> plainLine = line.chars()
                        .mapToObj(i -> (char) i).toList();

                List<Character> cipheredLine;
                if (context.getCryptoMethod() == CryptoMethod.ENCRYPTION) {
                    cipheredLine = Cryptographer.encrypt(plainLine, context.getShift());
                } else if (context.getCryptoMethod() == CryptoMethod.DECRYPTION) {
                    cipheredLine = Cryptographer.decrypt(plainLine, context.getShift());
                } else {
                    List<Character> plainLineTrimmed = plainLine.subList(0, Math.min(350, line.length()));
                    for (int i = 1; i < Cryptographer.ALPHABET.size(); i++) {
                        String res = (Cryptographer.decrypt(plainLineTrimmed, i)).stream()
                                .map(j -> j.toString())
                                        .collect(Collectors.joining(""));
                        writer.write(i + " - " + res + "\n");
                    }
                    return;
                }
                String res = cipheredLine.stream().map(String::valueOf).collect(Collectors.joining());
                writer.write(res);
            }
        } catch (IOException e) {
            assert true; // Чтобы не отображать повторную инфо об ошибках
        }
    }
}
