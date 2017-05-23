/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giacomo
 */
public class Group implements Shared {
    
    private int id;
    private List<User> userList;
    private PairGroup group;
    
    public Group () {
        this.id = -1;
        this.userList = new ArrayList<>();
        this.group =  null;
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
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * @return the user
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param user the user to set
     */
    public void addUser(User user) {
        this.userList.add(user) ;
    }
    
    /**
     * @param user the user to set
     */
    public void removeUser(User user) {
        this.userList.remove(user) ;
    }

    /**
     * @return the group
     */
    public PairGroup getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(PairGroup group) {
        this.group = group;
    }
    
}
