package com.pb.bolshakov.hw14;

public interface AuthService {

    String getNick(String login, String pass);

    boolean login(String login, String pass);
}