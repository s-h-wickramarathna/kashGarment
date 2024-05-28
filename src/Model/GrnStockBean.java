/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class GrnStockBean {
    
    private String stockID;
    private String stockName;
    private String stockColour;
    private String stockType;

    public String getStockID() {
        return stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public String getStockColour() {
        return stockColour;
    }

    public String getStockType() {
        return stockType;
    }

    public GrnStockBean(String stockID, String stockName, String stockColour, String stockType) {
        this.stockID = stockID;
        this.stockName = stockName;
        this.stockColour = stockColour;
        this.stockType = stockType;
    }
    
}
