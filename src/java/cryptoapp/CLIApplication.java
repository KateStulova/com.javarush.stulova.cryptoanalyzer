package cryptoapp;

import java.util.Scanner;

public class CLIApplication {

    public static void main(String[] args) {
        String pathFrom;
        String pathTo;
        String key;
        Controller controller = new Controller();
        Context context;

        do {
            Scanner input = new Scanner(System.in);

            System.out.println("Укажите желаемую процедуру обработки: encryption/decryption/bruteforce? ");
            String cryptoMethod = input.nextLine();

            System.out.println(
                    "Введите путь до существующего файла с текстом для криптографической обработки: "
            );
            pathFrom = input.nextLine();

            System.out.println(
                    "Введите путь, по которому вы хотите создать новый файл" +
                    " с результатами криптографической обработки: "
            );
            pathTo = input.nextLine();

            System.out.println("Введите ключ шифрования от 0 до " + Cryptographer.ALPHABET.size() + ": ");
            key = input.nextLine();

            context = Controller.getContext(cryptoMethod, pathFrom, pathTo, key);
            if (!context.isValid()) {
                System.out.println("Warning! При вводе данных были допущены следующие ошибки:");
                for (var error : context.getERRORS_LIST()) {
                    System.out.println("- " + error);
                }
                System.out.println("Старайтесь лучше, товарищ!");
                System.out.println("===================================================================");
            }
        } while (!context.isValid());


        controller.process(context);
    }
}