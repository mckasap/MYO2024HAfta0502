package com.example.myo2024hafta0502;

public class Calisanlar {
    private int id;
    private String lName;
    private String fName;
    private String email;

    public Calisanlar(int id, String lName, String fName, String email) {
        this.id = id;
        this.lName = lName;
        this.fName = fName;
        this.email = email;
    }
    public Calisanlar(){}
    public Calisanlar(String lName, String fName, String email) {
        this.lName = lName;
        this.fName = fName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return getfName()+" "+ getlName() +" " +getEmail();
    }
}
