package cryptoapp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Validator {
    public static ArrayList<String> validate(String cryptoMethod, String pathFrom, String pathTo, String key) {
        ArrayList<String> errorsList = new ArrayList<>();
        if (pathFrom.isEmpty()) {
            errorsList.add("Поле 'File input' не заполнено. Введите путь до файла.");
        }
        if (pathTo.isEmpty()) {
            errorsList.add("Поле 'File output' не заполнено. Введите путь до файла.");
        }
        if (!isCryptoMethodValid(cryptoMethod.toUpperCase())) {
            errorsList.add("Указанная процедура обработки '" + cryptoMethod + "' некорректна. Введите заново.");
        }
        if (!isKeyANumber(key)) {
            errorsList.add("Ключ '" + key + "' не является числом, введите число.");
        }
        if (!isFileExists(pathFrom)) {
            errorsList.add("Файл " + Path.of(pathFrom).getFileName() + " не найден, введите корректный путь к файлу.");
        }
        if (!pathTo.isEmpty() && isFileExists(pathTo)) {
            errorsList.add("Файл " + Path.of(pathTo).getFileName() + " уже существует, введите корректный путь.");
        }
        return errorsList;
    }

    private static boolean isCryptoMethodValid(String cryptoMethod) {
        return cryptoMethod.equals(CryptoMethod.ENCRYPTION.toString()) ||
                cryptoMethod.equals(CryptoMethod.DECRYPTION.toString()) ||
                cryptoMethod.equals(CryptoMethod.BRUTEFORCE.toString());
    }

    private static boolean isKeyANumber(String key) {
        boolean valid = false;
        try {
            Integer.parseInt(key);
            valid = true;
        } catch (NumberFormatException e) {
            assert true; // Чтобы не отображать повторную инфо об ошибках
        }

        return valid;
    }

    public static boolean isFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
