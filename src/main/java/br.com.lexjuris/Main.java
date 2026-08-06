package br.com.lexjuris;

import br.com.lexjuris.view.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        LoginView loginView = new LoginView(stage);

        Scene scene = new Scene(
                loginView.getView(),
                1000,
                650
        );

        stage.setTitle("LexMeta");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

//.\mvnw.cmd clean javafx:run