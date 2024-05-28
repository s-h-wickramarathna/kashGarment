/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class ClientBean {
    
    private String email;
    private String fname;
    private String lname;
    private String mobile;

    public ClientBean(String email, String fname, String lname, String mobile) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMobile() {
        return mobile;
    }
    
    
    
}
