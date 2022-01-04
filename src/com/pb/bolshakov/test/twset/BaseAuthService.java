package com.pb.bolshakov.test.twset;

import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService {
    private class Entry {
        private String login;
        private String password;
        private String nick;

        public Entry(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getNick() {
            return nick;
        }
    }

    private List<Entry> entries;

    public BaseAuthService() {
        entries = new ArrayList<>();
        entries.add(new Entry("Login1", "Pass1", "Rich"));
        entries.add(new Entry("Login2", "Pass2", "Anton"));
        entries.add(new Entry("Login3", "Pass3", "Petrovich"));
    }

    @Override
    public String getNick(String login, String pass) {
        for (Entry e : entries) {
            if (e.getLogin().equals(login) && e.getPassword().equals(pass)) return e.getNick();
        }
        return null;
    }

    @Override
    public boolean login(String login, String pass) {
        for (Entry e : entries) {
            if (e.getLogin().equals(login) && e.getPassword().equals(pass)) return true;
        }
        return false;
    }
}
