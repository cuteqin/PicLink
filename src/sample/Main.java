package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main extends Application {
    private final Desktop desktop = Desktop.getDesktop();
    private static final int CLIENT_ID = 0;
    private static final String CLIENT_SECRET = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button btn = new Button();
        btn.setText("打开文件");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                Stage stage = new Stage();
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    // openFile(file);
                    try {
                        String name = file.getName();
                        String md5 = FileUtils.getMd5ByFile(file);
                        long size = file.length();
                        System.out.println(md5);
                        System.out.println(name);
                        System.out.println(size);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(btn, 0, 0);
        // GridPane.setConstraints(openMultipleButton, 1, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(btn);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(120, 120, 120, 120));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

}
