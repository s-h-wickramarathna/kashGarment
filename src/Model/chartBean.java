/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class chartBean {
    
    private String month;
    private double amount;
    private double profit;
    private double lost;

    public chartBean(String month, double amount, double profit, double lost) {
        this.month = month;
        this.amount = amount;
        this.profit = profit;
        this.lost = lost;
    }

    public String getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }

    public double getProfit() {
        return profit;
    }

    public double getLost() {
        return lost;
    }

    
    
    
}
