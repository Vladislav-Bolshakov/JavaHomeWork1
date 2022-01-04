package com.pb.bolshakov.test.twset;

public interface AuthService {

    String getNick(String login, String pass);

    boolean login(String login, String pass);
}