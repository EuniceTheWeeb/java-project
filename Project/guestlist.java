package Project;

import java.util.Scanner;


public class guestlist {
    private String name;
    private String type;
    private String dateIn;
    private String dateOut;
    private int pax;
    private double totalCost;
    private String email;

    public guestlist() {
        name = "N/A";
        type = "N/A";
        dateIn = "N/A";
        dateOut = "N/A";
        pax = 0;
        Cost = 0;
        email = "N/A";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public guestlist(String name, String type, String dateIn, String dateOut, int pax, double totalCost, String email) {
        this.name = name;
        this.type = type;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.pax = pax;
        this.totalCost = totalCost;
        this.email = email;
    }

    
}
