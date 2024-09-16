package cryptoapp.controller;

import cryptoapp.Context;
import cryptoapp.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class UIController {
    @FXML
    protected void onOpenFileButtonClick(ActionEvent actionEvent) {

        // ПО НАЖАТИЮ НА КНОПКУ "ОТКРЫТЬ ФАЙЛ" ИЗ ИНТЕРФЕЙСА (fxml)
        // ВЫЗЫВАЕТСЯ МЕТОД КОНТРОЛЛЕРА onOpenFileButtonClick()
        FileChooser fileChooser = new FileChooser();
        // УСТАНАВЛИВАЕМ ЗАГОЛОВОК ОКНА
        fileChooser.setTitle("Choose file");
        // В МОМЕНТ ВЫБОРА ФАЙЛА ПУТЬ К НЕМУ ЗАПИШЕТСЯ В ПЕРЕМЕННУЮ fileInput
        File fileInput  = fileChooser.showOpenDialog(new Stage());

        // ИСПОЛЬЗУЕМ ПО НАЗНАЧЕНИЮ
        if (fileInput != null) {
            final Node source = (Node) actionEvent.getSource();
            Scene scene = source.getScene();
            TextField tf = (TextField) scene.lookup("#FileInputField");
            tf.setText(fileInput.toString());
        }
    }

    @FXML
    protected void onOpenFolderButtonClick(ActionEvent actionEvent) {

        // ПО НАЖАТИЮ НА КНОПКУ "ОТКРЫТЬ ДИРЕКТОРИЮ" ИЗ ИНТЕРФЕЙСА (fxml)
        // ВЫЗЫВАЕТСЯ МЕТОД КОНТРОЛЛЕРА onOpenFolderButtonClick()
        DirectoryChooser directoryChooser = new DirectoryChooser();
        // УСТАНАВЛИВАЕМ ЗАГОЛОВОК ОКНА
        directoryChooser.setTitle("Choose folder");
        // В МОМЕНТ ВЫБОРА ДИРЕКТОРИИ ПУТЬ К НЕМУ ЗАПИШЕТСЯ В ПЕРЕМЕННУЮ dirOutput
        File dirOutput = directoryChooser.showDialog(new Stage());

        // ИСПОЛЬЗУЕМ ПО НАЗНАЧЕНИЮ
        if (dirOutput != null) {
            final Node source = (Node) actionEvent.getSource();
            Scene scene = source.getScene();
            TextField tf = (TextField) scene.lookup("#FileOutputField");
            tf.setText(dirOutput.toString());
        }

    }

    @FXML
    protected void onProcessItButtonClick(ActionEvent actionEvent) {

        // ПО НАЖАТИЮ НА КНОПКУ "Ave, Caesar!" ИЗ ИНТЕРФЕЙСА (fxml)
        // ВЫЗЫВАЕТСЯ МЕТОД КОНТРОЛЛЕРА onProcessItButtonClick()
        // И ДАЛЬШЕ ЧИСТАЯ Java


        // ВЫЗВАЕМ МЕТОД ШИФРОВАНИЯ, ЧТО ИМЕННО ОН ДЕЛАЕТ - В НЕМ И ОПИСАНО
        Controller controller = new Controller();
        Context context;

        final Node source = (Node) actionEvent.getSource();
        Scene scene = source.getScene();
        String cryptoMethod = ((ChoiceBox) scene.lookup("#ModeChoiceBox")).getValue().toString();
        String pathFrom = ((TextField) scene.lookup("#FileInputField")).getText();
        String pathTo = ((TextField) scene.lookup("#FileOutputField")).getText();
        String key = ((Spinner) scene.lookup("#KeyValue")).getValue().toString();
        TextArea logs = (TextArea) scene.lookup("#LogsField");
        context = Controller.getContext(cryptoMethod, pathFrom, pathTo, key);
        if (!context.isValid()) {
            logs.appendText("Warning! При вводе данных были допущены следующие ошибки:\n");
            for (var error : context.getERRORS_LIST()) {
                logs.appendText("- " + error + "\n");
            }
            logs.appendText("Старайтесь лучше, товарищ!\n");
            logs.appendText("===================================================================\n");
            return;
        }

        controller.process(context);
        logs.appendText("Файл успешно обработан.\n");
    }
}
