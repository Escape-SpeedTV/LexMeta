package br.com.lexjuris.view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;

import br.com.lexjuris.controller.loginController;

public class LoginView {

    private final StackPane root;
    private final TextField email;
    private final PasswordField senha;
    private final loginController controller;

    public LoginView() {


        controller = new loginController();
        root = new StackPane();


        var css = getClass().getResource("/css/login.css");

        if (css != null) {
            root.getStylesheets().add(css.toExternalForm());
        }


        Label titulo = new Label("LexMeta");
        titulo.getStyleClass().add("login-title");


        email = new TextField();
        email.setPromptText("E-mail");
        email.getStyleClass().add("login-input");


        senha = new PasswordField();
        senha.setPromptText("Senha");
        senha.getStyleClass().add("login-input");


        CheckBox lembrar = new CheckBox("Lembrar de mim");
        lembrar.getStyleClass().add("login-checkbox");


        Button entrar = new Button("ENTRAR");
        entrar.getStyleClass().add("login-button");

        entrar.setOnAction(event -> {
            String emailDigitado = email.getText();
            String senhaDigitada = senha.getText();
            System.out.println("E-mail: " + emailDigitado);
            System.out.println("Senha: " + senhaDigitada);

            if(emailDigitado.isEmpty() || senhaDigitada.isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Atenção");
                alerta.setHeaderText(null);
                alerta.setContentText("Preencha todos os campos.");

                alerta.showAndWait();
                return;
            }

            controller.fazerLogin(emailDigitado, senhaDigitada);
        });


        Hyperlink esqueceuSenha =
                new Hyperlink("Esqueceu sua senha?");

        esqueceuSenha.getStyleClass().add("login-link");

        VBox formulario = new VBox(15);

        formulario.getStyleClass().add("login-form");

        formulario.getChildren().addAll(
                titulo,
                email,
                senha,
                lembrar,
                entrar,
                esqueceuSenha
        );

        root.getChildren().add(formulario);
    }

    public StackPane getView() {
        return root;
    }
}