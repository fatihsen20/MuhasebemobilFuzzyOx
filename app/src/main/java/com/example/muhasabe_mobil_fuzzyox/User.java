package com.example.muhasabe_mobil_fuzzyox;

public class User {
    private String name, surname, e_mail, pass;

    public User(String name, String surname, String e_mail, String pass) {
        this.name = name;
        this.surname = surname;
        this.e_mail = e_mail;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
