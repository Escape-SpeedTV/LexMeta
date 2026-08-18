package br.com.lexjuris.view;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.lexjuris.controller.loginController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Cursor;

public class LoginView {

    private final StackPane root;
    private final TextField email;
    private TextField senha;
    private final loginController controller;

    public LoginView(Stage stage) {

        controller = new loginController();
        root = new StackPane();

        VBox painelEsquerdo = new VBox(25);
        painelEsquerdo.setAlignment(Pos.TOP_LEFT);
        painelEsquerdo.setPadding(new Insets(50, 40, 50, 60));

        VBox painelDireito = new VBox();
        painelDireito.setAlignment(Pos.CENTER);
        painelDireito.setFillWidth(true);
        painelDireito.setPadding(new Insets(40));

        // Cartão Branco
        VBox cartaoLogin = new VBox(15);
        cartaoLogin.setAlignment(Pos.CENTER);
        cartaoLogin.setPadding(new Insets(40, 50, 40, 50));
        cartaoLogin.setPrefWidth(490);
        cartaoLogin.setMaxWidth(490);
        cartaoLogin.setPrefHeight(640);
        cartaoLogin.setMaxHeight(640);
        cartaoLogin.getStyleClass().add("login-card");

        // Container do formulári
        VBox formularioContainer = new VBox(15);
        formularioContainer.setAlignment(Pos.CENTER);
        formularioContainer.setPadding(new Insets(40));
        formularioContainer.setMaxWidth(400);

        // Títulos e Labels
        Label titulo = new Label("Bem-Vindo de Volta!");
        titulo.getStyleClass().add("login-title");

        Label subtitulo = new Label("Faça login para acessar sua conta");
        subtitulo.getStyleClass().add("login-subtitle");

        // Campo E-mail
        Label emailLabel = new Label("E-mail");
        emailLabel.getStyleClass().add("input-label");

        email = new TextField();
        email.setPromptText("seu@email.com");
        email.getStyleClass().add("login-input-field");
        email.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        ImageView iconeUsuario = new ImageView(new Image(getClass().getResourceAsStream("/imagens/pngtree-vector-business-men-icon-png-image_925963.png")));

        iconeUsuario.setFitWidth(20);
        iconeUsuario.setFitHeight(20);
        iconeUsuario.setPreserveRatio(true);

        Region linhaVertical = new Region();
        linhaVertical.setPrefWidth(1);
        linhaVertical.setStyle("-fx-border-color: #e0e0e0; -fx-border-width: 0 1 0 0;");

        HBox emailInputContainer = new HBox(15);
        emailInputContainer.setAlignment(Pos.CENTER_LEFT);
        emailInputContainer.setPadding(new Insets(0, 0, 0, 15));

        emailInputContainer.getStyleClass().add("login-input-container");
        emailInputContainer.getChildren().addAll(iconeUsuario, email);

        HBox.setHgrow(email, Priority.ALWAYS);

        VBox emailBox = new VBox(7, emailLabel, emailInputContainer);

        // Campo Senha
        Label senhaLabel = new Label("Senha");
        senhaLabel.getStyleClass().add("input-label");

        TextField senhaVisivel = new TextField();
        senhaVisivel.setPromptText("Digite sua senha");
        senhaVisivel.getStyleClass().add("login-input-field");
        senhaVisivel.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        PasswordField senhaOculta = new PasswordField();
        senhaOculta.setPromptText("Digite sua senha");
        senhaOculta.getStyleClass().add("login-input-field");
        senhaOculta.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        senhaOculta.setVisible(true);
        senhaVisivel.setVisible(false);
        senha = senhaVisivel;

        StackPane senhaStack = new StackPane();
        senhaStack.getChildren().addAll(senhaOculta, senhaVisivel);

        senhaVisivel.prefWidthProperty().bind(senhaStack.widthProperty());
        senhaOculta.prefWidthProperty().bind(senhaStack.widthProperty());

        ImageView iconeCadeado = new ImageView(new Image(getClass().getResourceAsStream("/imagens/393a7d8e436bccc3aedfd43865b48890-icone-de-cadeado.webp")));
        iconeCadeado.setFitWidth(20);
        iconeCadeado.setFitHeight(20);
        iconeCadeado.setPreserveRatio(true);

        ImageView iconeOlho = new ImageView(new Image(getClass().getResourceAsStream("/imagens/olho.png")));
        iconeOlho.setFitWidth(20);
        iconeOlho.setFitHeight(20);
        iconeOlho.setPreserveRatio(true);
        iconeOlho.setOpacity(0.6);

        Region linhaVertical1 = new Region();
        linhaVertical1.setPrefWidth(1);
        linhaVertical1.setStyle("-fx-border-color: #e0e0e0; -fx-border-width: 0 1 0 0;");

        Region linhaVertical2 = new Region();
        linhaVertical2.setPrefWidth(1);
        linhaVertical2.setStyle("-fx-border-color: #e0e0e0; -fx-border-width: 0 1 0 0;");

        HBox senhaInputContainer = new HBox(10);
        senhaInputContainer.setAlignment(Pos.CENTER_LEFT);
        senhaInputContainer.setPadding(new Insets(0, 0, 0, 15));
        senhaInputContainer.getStyleClass().add("login-input-container");

        senhaInputContainer.getChildren().addAll(iconeCadeado, linhaVertical, senhaStack, iconeOlho);
        HBox.setHgrow(senhaStack, Priority.ALWAYS);

        StackPane botaoOlho = new StackPane(iconeOlho);
        botaoOlho.setPadding(new Insets(10));
        botaoOlho.setCursor(Cursor.HAND);

        botaoOlho.setOnMouseClicked(event -> {

            boolean estaVisivel = senhaVisivel.isVisible();
            if (estaVisivel) {
                senhaOculta.setText(senhaVisivel.getText());
                senhaVisivel.setVisible(false);
                senhaOculta.setVisible(true);
                senha = senhaOculta;
                iconeOlho.setImage(new Image(getClass().getResourceAsStream("/imagens/olho.png")));
            } else {
                senhaVisivel.setText(senhaOculta.getText());
                senhaOculta.setVisible(false);
                senhaVisivel.setVisible(true);
                senha = senhaVisivel;
                iconeOlho.setImage(new Image(getClass().getResourceAsStream("/imagens/olhoAberto.png")));
            }
        });

        senhaInputContainer.getChildren().remove(iconeOlho);
        senhaInputContainer.getChildren().add(botaoOlho);

        VBox senhaBox = new VBox(7, senhaLabel, senhaInputContainer);

        // Linha Inferior
        HBox linhaInferior = new HBox();
        linhaInferior.setAlignment(Pos.CENTER_LEFT);
        linhaInferior.setSpacing(10);

        CheckBox lembrar = new CheckBox("Lembrar de mim");
        lembrar.getStyleClass().add("login-checkbox");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Hyperlink esqueceuSenha = new Hyperlink("Esqueceu sua senha?");
        esqueceuSenha.getStyleClass().add("login-link");
        esqueceuSenha.setOnAction(event -> {
            System.out.println("Navegar para recuperação de senha");
        });
        linhaInferior.getChildren().addAll(lembrar, spacer, esqueceuSenha);

        // Botão Entrar
        Button entrar = new Button("ENTRAR");
        entrar.getStyleClass().add("login-button");
        entrar.setMaxWidth(Double.MAX_VALUE); // Ocupa a largura total do VBox
        entrar.setOnAction(event -> {
            String emailDigitado = email.getText();
            String senhaDigitada = senha.getText();

            if (emailDigitado.isEmpty() || senhaDigitada.isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Atenção");
                alerta.setHeaderText(null);
                alerta.setContentText("Preencha todos os campos.");
                alerta.showAndWait();
                return;
            }

            boolean loginValido = controller.fazerLogin(emailDigitado, senhaDigitada);

            if (loginValido) {
                dashboardview dbView = new dashboardview();
                Scene dashboardScene = new Scene(dbView.getRoot(), 1200, 800);
                stage.setScene(dashboardScene);
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Login");
                alerta.setHeaderText(null);
                alerta.setContentText("E-mail ou senha incorretos.");
                alerta.showAndWait();
            }
        });

        // Rodapé
        HBox rodapeBox = new HBox(5);
        rodapeBox.setAlignment(Pos.CENTER);
        Label rodapeTexto = new Label("Ainda não tem uma conta?");
        rodapeTexto.getStyleClass().add("Login-footer-text");

        Hyperlink linkAdmin = new Hyperlink("Fale com o administrador");
        linkAdmin.getStyleClass().add("login-link");
        rodapeBox.getChildren().addAll(rodapeTexto, linkAdmin);

        StackPane.setAlignment(cartaoLogin, Pos.CENTER_RIGHT);
        StackPane.setMargin(cartaoLogin, new Insets(0, 120, 0, 0));

        // Montagem do Formulário
        cartaoLogin.getChildren().addAll(
                titulo,
                subtitulo,
                emailBox,
                senhaBox,
                linhaInferior,
                entrar,
                new Separator(),
                rodapeBox
        );

        Region espacoTopo = new Region();
        espacoTopo.setPrefHeight(30);

        Region mola = new Region();
        VBox.setVgrow(mola, Priority.ALWAYS);

        VBox.setMargin(cartaoLogin, new Insets(30, 0, 0, 0));

        HBox rodapeTela = new HBox();
        rodapeTela.setAlignment(Pos.CENTER_LEFT);
        rodapeTela.setPadding(new Insets(0, 50, 5, 50));
        VBox.setMargin(rodapeTela, new Insets(35, 0, 0, 0));
        rodapeTela.setMaxWidth(Double.MAX_VALUE);

        ImageView iconeEscudo = new ImageView(new Image(getClass().getResourceAsStream("/imagens/315.png")));
        iconeEscudo.setFitWidth(14);
        iconeEscudo.setFitHeight(14);
        iconeEscudo.setPreserveRatio(true);
//
        Label textoSeguro = new Label("Sistema seguro e protegido");
        textoSeguro.getStyleClass().add("footer-text");

        HBox ladoEsquerdo = new HBox(10);
        ladoEsquerdo.setAlignment(Pos.CENTER_LEFT);
        ladoEsquerdo.getChildren().addAll(iconeEscudo, textoSeguro);

        Region espacoMedio = new Region();
        HBox.setHgrow(espacoMedio, Priority.ALWAYS);


        Label textoDireitos = new Label("©2026 LexMeta. Todos os direitos reservados.");
        textoDireitos.getStyleClass().add("footer-text");

        rodapeTela.getChildren().addAll(ladoEsquerdo, espacoMedio, textoDireitos);

        painelDireito.getChildren().addAll(espacoTopo,cartaoLogin, mola, rodapeTela);

        HBox telaPrincipal = new HBox();
        telaPrincipal.getChildren().addAll(painelEsquerdo, painelDireito);
        HBox.setHgrow(painelEsquerdo, Priority.ALWAYS);
        HBox.setHgrow(painelDireito, Priority.ALWAYS);
        painelEsquerdo.setPrefWidth(550);

        root.getChildren().add(telaPrincipal);

        // Carrega o CSS
        var css = getClass().getResource("/css/login.css");
        if (css != null) {
            root.getStylesheets().add(css.toExternalForm());
        }
    }

    public StackPane getView() {
        return root;
    }
}