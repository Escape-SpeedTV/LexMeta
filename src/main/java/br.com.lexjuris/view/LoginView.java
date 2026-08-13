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
import javafx.geometry.Insets;
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

        //Container Principal
        HBox tela = new HBox();
        tela.getStyleClass().add("login-screen");

        //Painel Esquerdo Tela Login
        VBox painelEsquerdo = new VBox(20);
        painelEsquerdo.getStyleClass().add("login-left");
        painelEsquerdo.setAlignment(Pos.CENTER_LEFT);
        painelEsquerdo.setPadding(new Insets(60, 50, 60, 60));


        Label tituloPrincipal = new Label("GESTÃO JURÍDICA\nCOM INTELIGÊNCIA");
        tituloPrincipal.getStyleClass().add("main-title");
        tituloPrincipal.setWrapText(true);

        Label subtituloPrincipal = new Label(
                "Organize processo, acompanhe resultados e impulsione o desempenho do seu escritório."
        );

        subtituloPrincipal.getStyleClass().add("main-subtitle");
        subtituloPrincipal.setWrapText(true);

//        VBox cardsBox.getChildren().addAll(
//
//        )

        painelEsquerdo.getChildren().addAll(
                tituloPrincipal,
                subtituloPrincipal
        );

        //Painel Direito Tela Login
        VBox painelDireito = new VBox();
        painelDireito.getStyleClass().add("login-right");
        painelDireito.setAlignment(Pos.CENTER);
        painelDireito.setPadding(new Insets(40));

        Label titulo = new Label("Bem-Vindo de Volta!");
        titulo.getStyleClass().add("login-title");

        Label subtitulo = new Label("Faça login para acessar sua conta");
        subtitulo.getStyleClass().add("login-subtitle");

        Label emailLabel = new Label("E-mail");
        emailLabel.getStyleClass().add("input-label");

        email = new TextField();
        email.setPromptText("seu@email.com");
        email.getStyleClass().add("login-input");

        VBox emailBox = new VBox(7);
        emailBox.getChildren().addAll(emailLabel, email);


        Label senhaLabel = new Label("Senha");
        senhaLabel.getStyleClass().add("input-label");

        senha = new PasswordField();
        senha.setPromptText("Digite sua senha");
        senha.getStyleClass().add("login-input");

        VBox senhaBox = new VBox(7);
        senhaBox.getChildren().addAll(senhaLabel, senha);

        HBox linhaInferior = new HBox();
        linhaInferior.setAlignment(Pos.CENTER_LEFT);
        linhaInferior.setSpacing(20);

        CheckBox lembrar = new CheckBox("Lembrar de mim");
        lembrar.getStyleClass().add("login-checkbox");

        Hyperlink esqueceuSenha = new Hyperlink("Esqueceu sua senha?");
        esqueceuSenha.getStyleClass().add("login-link");

        esqueceuSenha.setOnAction(event -> {
            System.out.println("Navegar para recuperação de senha");
        });

        Button entrar = new Button("ENTRAR");
        entrar.getStyleClass().add("login-button");
        entrar.setMaxWidth(Double.MAX_VALUE);
        entrar.setOnAction(event -> {
            String emailDigitado = email.getText();
            String senhaDigitada = senha.getText();

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
                Scene dashboardScene = new Scene(dbView.getRoot(), 1200, 800);
                stage.setScene(dashboardScene);
            }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("login");
                alerta.setHeaderText(null);
                alerta.setContentText("E-mail ou senha incorretos.");
                alerta.showAndWait();
            }
        });

        Label rodape = new Label("Ainda não tem uma conta? Fale com o administrador");
        rodape.getStyleClass().add("Login-footer");

        VBox formulario = new VBox(15);
        formulario.getStyleClass().add("login-form");

        formulario.setMaxWidth(380);
        formulario.setAlignment(Pos.CENTER);
        linhaInferior.getChildren().addAll(lembrar, esqueceuSenha);

        formulario.getChildren().addAll(
               titulo,
                subtitulo,
                emailBox,
                senhaBox,
                linhaInferior,
                entrar,
                rodape
        );

        painelDireito.getChildren().add(formulario);

        //Paines HBOX

        HBox.setHgrow(painelEsquerdo, Priority.ALWAYS);
        HBox.setHgrow(painelDireito, Priority.ALWAYS);

        painelEsquerdo.setPrefWidth(400);
        painelDireito.setPrefWidth(600);

        tela.getChildren().addAll(painelEsquerdo, painelDireito);
        root.getChildren().add(tela);
        var css = getClass().getResource("/css/login.css");
        if (css != null) {
            root.getStylesheets().add(css.toExternalForm());
        }

    }

    private HBox criarCard(String icone, String texto) {
        HBox card = new HBox(10);
        card.getStyleClass().add("feature-card");
        card.setAlignment(Pos.CENTER_LEFT);

        Label iconeLabel = new Label(icone);
        iconeLabel.getStyleClass().add("feature-icon");

        Label textoLabel = new Label(texto);
        textoLabel.getStyleClass().add("feature-text");

        card.getChildren().addAll(iconeLabel, textoLabel);
        return card;
    }

    public StackPane getView(){
        return root;
    }
}