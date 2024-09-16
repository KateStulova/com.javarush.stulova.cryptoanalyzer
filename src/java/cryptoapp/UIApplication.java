package cryptoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class UIApplication extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UIApplication.class.getResource("cryptoapp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 619, 546);
        ChoiceBox cb = (ChoiceBox) scene.lookup("#ModeChoiceBox");
        List<Object> enumList = List.of(CryptoMethod.values()).stream()
                .map(x -> (Object) x)
                .filter(x -> !x.equals(CryptoMethod.UNKNOWN))
                .toList();
        ObservableList<Object> methods = FXCollections.observableList(enumList);
        cb.setItems(methods);
        cb.setValue(enumList.get(0));
        Spinner spinner = (Spinner) scene.lookup("#KeyValue");
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
        primaryStage.setTitle("Ave, Caesar!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
