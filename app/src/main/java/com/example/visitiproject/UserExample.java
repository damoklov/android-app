package com.example.visitiproject;

class UserExample {
    private String email;
    private String password;

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    private String rights;

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

    @Override
    public String toString() {
        return "UserExample{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rights='" + rights + '\'' +
                '}';
    }
}
