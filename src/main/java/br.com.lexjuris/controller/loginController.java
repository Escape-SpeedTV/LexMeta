package br.com.lexjuris.controller;

public class loginController {
    public boolean fazerLogin(String email, String senha){
        String emailCorreto = "miku@gmail.com";
        String senhaCorreta = "1234567890";
        if(email.equals(emailCorreto) && senha.equals(senhaCorreta)){
            return true;
        }
        return false;
    }
}