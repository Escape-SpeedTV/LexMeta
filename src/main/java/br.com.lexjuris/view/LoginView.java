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
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
//import javafx.scene.layout.Region;

import br.com.lexjuris.controller.loginController;

public class LoginView {

    private final StackPane root;
    private final TextField email;
    private final PasswordField senha;
    private final loginController controller;

    public LoginView(Stage stage) {


        controller = new loginController();
        root = new StackPane();

        HBox tela = new HBox();
        tela.getStyleClass().add("login-screen");

        StackPane painelEsquerdo = new StackPane();
        painelEsquerdo.getStyleClass().add("login-left");

        StackPane painelDireito = new StackPane();
        painelDireito.getStyleClass().add("login-right");

//        Region diagonal = new Region();
//        diagonal.getStyleClass().add("login-diagonal");
//
//        diagonal.setPrefWidth(100);
//        diagonal.prefHeightProperty().bind(tela.heightProperty().multiply(1.3));
//
//        diagonal.setRotate(7);
//        diagonal.setTranslateX(-45);
//        diagonal.setMouseTransparent(true);

        HBox.setHgrow(painelEsquerdo, Priority.ALWAYS);
        HBox.setHgrow(painelDireito, Priority.ALWAYS);

        painelEsquerdo.setPrefWidth(47);
        painelDireito.setPrefWidth(53);

        tela.getChildren().addAll(
                painelEsquerdo, painelDireito
        );


        root.getChildren().add(tela);

        painelDireito.setAlignment(Pos.CENTER);



        var css = getClass().getResource("/css/login.css");

        if (css != null) {
            root.getStylesheets().add(css.toExternalForm());
        }


        Label titulo = new Label("Bem-Vindo de Volta!");
        titulo.getStyleClass().add("login-title");

        Label subtitulo = new Label("Faça login para acessar sua conta");
        subtitulo.getStyleClass().add("login-subtitle");

        Label emailLabel = new Label("E-mail");
        emailLabel.getStyleClass().add("input-label");

        email = new TextField();
        email.setPromptText("E-mail");
        email.getStyleClass().add("login-input");


        Label senhaLabel = new Label("Senha");
        senhaLabel.getStyleClass().add("input-label");

        senha = new PasswordField();
        senha.setPromptText("Senha");
        senha.getStyleClass().add("login-input");

        VBox emailBox = new VBox(7);
        emailBox.getChildren().addAll(
                emailLabel,
                email
        );

        VBox senhaBox = new VBox(7);
        senhaBox.getChildren().addAll(
                senhaLabel,
                senha
        );


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

            boolean loginValido = controller.fazerLogin(emailDigitado, senhaDigitada);

            if(loginValido) {
                dashboardview dbView = new dashboardview();

                Scene dashboardScene = new Scene(
                        dbView.getRoot(), 800, 600
                );
                stage.setScene(dashboardScene);
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("login");
                alerta.setHeaderText(null);
                alerta.setContentText("E-mail ou senha incorretos.");

                alerta.showAndWait();
            }
        });


        Hyperlink esqueceuSenha =
                new Hyperlink("Esqueceu sua senha?");

        esqueceuSenha.setOnAction(event -> {
            RecuperacaoSenhaView recuperacao = new RecuperacaoSenhaView(stage);

            Scene cenaRecuperacao = new Scene(recuperacao.getroot(), 800, 600);

            stage.setScene(cenaRecuperacao);
        })

        esqueceuSenha.getStyleClass().add("login-link");

        VBox formulario = new VBox(15);

        formulario.getStyleClass().add("login-form");

        formulario.getChildren().addAll(
                titulo,
                subtitulo,
                emailBox,
                senhaBox,
                lembrar,
                entrar,
                esqueceuSenha
        );

        painelDireito.getChildren().add(formulario);

    }

    public StackPane getView() {
        return root;
    }
}