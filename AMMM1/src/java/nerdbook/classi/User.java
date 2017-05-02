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
    private String profImagePath;
    private String presentation;
    private String username;
    private String password;
    
    public User () {
        this.id = -1;
        this.name = null;
        this.surname = null;
        this.date = null;
        this.profImagePath = null;
        this.presentation = null;
        this.username = null;
        this.password = null;
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
     * @return the profImagePath
     */
    public String getProfImagePath() {
        return profImagePath;
    }

    /**
     * @param profImagePath the profImagePath to set
     */
    public void setProfImagePath(String profImagePath) {
        this.profImagePath = profImagePath;
    }

    /**
     * @return the presentation
     */
    public String getPresentation() {
        return presentation;
    }

    /**
     * @param presentation the presentation to set
     */
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
