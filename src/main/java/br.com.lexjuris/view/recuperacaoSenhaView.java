package br.com.lexjuris.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.textField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class recuperacaoSenhaView{
    private final VBox root;

    public recuperacaoSenhaView(Stage stage){
        root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        Label titulo = new Label("Recuperação de senha");
        Label mensagem = new Label("Digite seu e-mail para recuperar sua senha");

        TextField email = new TextField();
        email.setPromptText("E-mail");

        Button recuperar = new Button("RECUPERAR");

        Button voltar = new Button("VOLTAR");

        root.getChildren().addAll(
                titulo,
                mensagem,
                email,
                recuperar,
                voltar
        );
    }

    public VBox getRoot(){}
    return root;
}