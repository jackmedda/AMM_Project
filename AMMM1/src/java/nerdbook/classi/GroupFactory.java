/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giacomo
 */
public class GroupFactory {
    
    private static GroupFactory singleton;

    public static GroupFactory getInstance() {
        if (singleton == null) {
            singleton = new GroupFactory();
        }
        return singleton;
    }

    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }

    private GroupFactory() {
    }

    public Group getGroupById(int id) {
        try {
            Group current = new Group();
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select * from groups "
                    + "where group_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            if (res.next()) {
                
                current.setId(res.getInt("group_id"));
                current.setGroup(new PairGroup(res.getString("group_name"), res.getString("group_image")));
                
                stmt.close();
                conn.close();
                return current;
            }
            
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Group> getGroupsList(User usr) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select * from group_registered "
                    + "where usr_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, usr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            if(!res.next()) {
                stmt.close();
                conn.close();
            }
            else {
                List<Group> listGroups = new ArrayList<>();
                do {
                    listGroups.add(getGroupById(res.getInt("grp_id")));
                } while(res.next());
                
                stmt.close();
                conn.close();
                return listGroups;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Group> getOtherGroups(Group currGrp, User loggedUsr) {
        List<Group> groupsList = getGroupsList(loggedUsr);
        
        groupsList.remove(currGrp);
        
        return groupsList;
    }
}
