package com.example.sprint1;

public class clientmod {
    private String cName;
    private int clientID;
    private String email;
    private String password;

    public clientmod(String name, int id, String email, String password) {
        this.cName = name;
        this.clientID = id;
        this.email = email;
        this.password = password;
    }



    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
