package com.project.visiti;

class User {
    private String email;
    private String password;
    private String rights;

    public User() {
    }

    public User(String email, String password, String rights) {
        this.email = email;
        this.password = password;
        this.rights = rights;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
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

    @Override
    public String toString() {
        return "UserExample{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rights='" + rights + '\'' +
                '}';
    }
}
