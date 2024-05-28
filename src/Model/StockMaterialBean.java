/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class StockMaterialBean {
    
    private String materialID;
    private String materialName;
    private String materialType;

    public StockMaterialBean(String materialID, String materialName, String materialType) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialType = materialType;
    }

    public String getMaterialID() {
        return materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getMaterialType() {
        return materialType;
    }
    
    
    
}
