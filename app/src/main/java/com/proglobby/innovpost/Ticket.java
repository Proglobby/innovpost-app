package com.proglobby.innovpost;

public class Ticket {
    private String tickets;
    private int index;
    private int zip;

    public Ticket(int index, int zip) {
        this.index = index;
        this.zip = zip;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getRemaining(int total) {

        return index - total;  // Cal diff between total and the index
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tickets='" + tickets + '\'' +
                ", index=" + index +
                ", zip=" + zip +
                '}';
    }
}
