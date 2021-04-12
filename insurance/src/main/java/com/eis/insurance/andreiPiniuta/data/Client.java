package com.eis.insurance.andreiPiniuta.data;

public class Client {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String printClientInfo() {
        return "Client is "+firstName+ " "+lastName + ".";
    }
}

