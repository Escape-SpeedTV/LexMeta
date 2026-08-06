package br.com.lexjuris.view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class dashboardview {
    private final StackPane root;

    public dashboardview(){
        root = new StackPane();
        Label titulo = new Label("Dashboard de LexMeta");

        root.getChildren().add(titulo);
    }

    public StackPane getRoot() {
        return root;
    }
}