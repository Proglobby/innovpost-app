package com.proglobby.innovpost;

public class User {
    private String ccpNumber;
    private String email;
    private Feedback feedback;
    private String name;
    private long phone;
    private int numberOfTickets;

    public User(String ccpNumber, String email, Feedback feedback, String name, long phone, int numberOfTickets) {
        this.ccpNumber = ccpNumber;
        this.email = email;
        this.feedback = feedback;
        this.name = name;
        this.phone = phone;
        this.numberOfTickets = numberOfTickets;
    }

    public String getCcpNumber() {
        return ccpNumber;
    }

    public void setCcpNumber(String ccpNumber) {
        this.ccpNumber = ccpNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "ccpNumber='" + ccpNumber + '\'' +
                ", email='" + email + '\'' +
                ", feedback=" + feedback +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
