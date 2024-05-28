/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.UUID;

/**
 *
 * @author Lenovo
 */
public class GenerateUID {

    public GenerateUID() {}

    public String generateUniqueId() {
        String text = String.valueOf(UUID.randomUUID());
        String[] results = text.split("(-)");
        String id = "#" + results[0];
        return id;

    }
}
