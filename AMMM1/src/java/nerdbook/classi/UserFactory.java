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
public class UserFactory {
    
    private static UserFactory singleton;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }

    private UserFactory() {
    }
   
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
        return this.connectionString;
    }

    public User getUserById(int id) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select * from users "
                    + "where user_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                User current = new User();
                current.setId(res.getInt("user_id"));
                current.setName(res.getString("name"));
                current.setSurname(res.getString("surname"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setDate(res.getDate("user_date"));
                current.setPresentation(res.getString("presentation"));
                current.setProfImagePath(res.getString("profImagePath"));

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
    
    public int getIdByUserAndPassword(String username, String password){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select user_id from users "
                    + "where username = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("user_id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;      
    }
    
    
    public List<User> getUserFriends(User user) {
        try {
            //Si è scelto di controllare delle amicizie, piuttosto che following-follower
            List<User> friends = new ArrayList<>();
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select * from friends "
                    + "where usr1_id = ? or usr2_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            stmt.setInt(2, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            // ciclo sulle righe restituite
            if(!res.next()) {
                stmt.close();
            }
            else {
                do {
                    String friend;
                    if(res.getInt("usr1_id") == user.getId())
                        friend = "usr2_id";
                    else
                        friend = "usr1_id";

                    friends.add(getUserById(res.getInt(friend)));
                } while (res.next());
                
                stmt.close();
                conn.close();
                return friends;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void updateProfile(User user, int id) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "update users set name = ?, surname = ?, password = ?, user_date = ?, "
                    + "presentation = ?, profImagePath = ?"
                    + "where user_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getPassword());
            stmt.setDate(4, user.getDate());
            stmt.setString(5, user.getPresentation());
            stmt.setString(6, user.getProfImagePath());
            stmt.setInt(7, id);
            
            // Esecuzione query
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(User usr) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "delete from users "
                    + "where user_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, usr.getId());
            
            // Esecuzione query
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
