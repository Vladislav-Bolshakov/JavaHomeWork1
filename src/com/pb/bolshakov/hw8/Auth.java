package com.pb.bolshakov.hw8;

import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;
    private String confirmPassword;

    public Auth() {
    }

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login != null && Pattern.matches("[\\w]{5,20}", login)) {
            if (password != null && Pattern.matches("[\\w]{5,20}", password)) {
                if (!password.equals(confirmPassword)) {
                    throw new WrongPasswordException("Password not confirmed");
                } else {
                    this.login = login;
                    this.password = password;
                    this.confirmPassword = confirmPassword;
                }
            } else {
                throw new WrongPasswordException("Длина пароля от 5 символов,содержать только буквы, цифры и символ");
            }
        } else {
            throw new WrongLoginException("Длина логина от 5 до 20 символов,только из букв и цифр");
        }
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (!this.login.equals(login)) {
            throw new WrongLoginException("Пользователь не сушествует");
        } else if (!this.password.equals(password)) {
            throw new WrongLoginException("Пользователь не сушествует");
        }
    }
}
