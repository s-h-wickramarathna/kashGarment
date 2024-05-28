/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class InvoiceProductBean {

   private String stock_id;
   private String id;
   private String name;
   private String description;
   private String color;
   private String start;
   private String end;
   private String quentity;
   private String unitPrice;
   private String damage;

    public InvoiceProductBean(String stock_id, String id, String name, String description, String color, String start, String end, String quentity, String unitPrice, String damage) {
        this.stock_id = stock_id;
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.start = start;
        this.end = end;
        this.quentity = quentity;
        this.unitPrice = unitPrice;
        this.damage = damage;
    }

    public String getId() {
        return id;
    }
    
    public String getStock_Id() {
        return stock_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getQuentity() {
        return quentity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getDamage() {
        return damage;
    }
   
   

}
