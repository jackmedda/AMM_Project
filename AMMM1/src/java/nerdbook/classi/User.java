/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.classi;

import java.sql.Date;

/**
 *
 * @author Giacomo
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private Date date;
    private String urlProfImage;
    private String password;
    
    public User () {
        this.id = 0;
        this.name = "";
        this.surname = "";
        this.date = null;
        this.urlProfImage = "";
        this.password = "";
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = Date.valueOf(date);
    }

    /**
     * @return the urlProfImage
     */
    public String getUrlProfImage() {
        return urlProfImage;
    }

    /**
     * @param urlProfImage the urlProfImage to set
     */
    public void setUrlProfImage(String urlProfImage) {
        this.urlProfImage = urlProfImage;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
