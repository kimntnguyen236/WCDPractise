/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptaptech.testwebjdbc.Models;

/**
 *
 * @author lenovo
 */
public class tbUser {
    private int UserID;
    private String UserName;
    private String Password;

    public tbUser() {
    }

    public tbUser(int UserID, String UserName, String Password) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.Password = Password;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
