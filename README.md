# Реализация шифра Цезаря

Код представляет собой JavaFX приложение, шифрующее и дешифрующее текстовые файлы с помощью шифра Цезаря.

### Системные требования

- OpenJDK 17+

### Точки входа

- [UIApplication](src/java/cryptoapp/UIApplication.java) - вариант с JavaFX интерфейсом
- [CLIApplication](src/java/cryptoapp/CLIApplication.java) - вариант с консолью

### Для запуска приложения из jar файла

Выполнить следующую команду:
```shell
java --module-path lib/javafx --add-modules javafx.controls,javafx.fxml -jar bin/cryptoapp.jar
```
