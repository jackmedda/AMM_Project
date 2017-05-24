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
public class PostFactory {
    
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    private PostFactory() {
    }

    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    
    public Post getPostById(int id) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select * from posts "
                    + "where post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                
                current.setId(res.getInt("post_id"));
                if(res.getBoolean("shared_on_user")) 
                    current.setShared(UserFactory.getInstance().getUserById(res.getInt("shared_user")));
                else
                    current.setShared(GroupFactory.getInstance().getGroupById(res.getInt("shared_group")));
                current.setSharer(UserFactory.getInstance().getUserById(res.getInt("sharer")));
                current.setContent(res.getString("content"));
                current.setPostType(this.postTypeFromInt(res.getInt("type")));
                current.setPostContent(res.getString("postContent"));

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

    public List<Post> getPostList(User usr) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select * from posts "
                    + "join users on shared_user = user_id "
                    + "where user_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, usr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (!res.next()) {
                stmt.close();
                conn.close();
            }
            else {
                List<Post> postList = new ArrayList<>();
                do {
                    Post current = new Post();

                    current.setId(res.getInt("post_id"));
                    current.setShared(usr);
                    current.setSharer(UserFactory.getInstance().getUserById(res.getInt("sharer")));
                    current.setContent(res.getString("content"));
                    current.setPostType(this.postTypeFromInt(res.getInt("type")));
                    current.setPostContent(res.getString("postContent"));
                    
                    postList.add(current);

                } while(res.next());
                
                stmt.close();
                conn.close();
                return postList;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Post> getPostList(Group group) {
        List<Post> postList = new ArrayList<>();
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "select * from posts "
                    + "join groups on shared_group = group_id "
                    + "where group_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, group.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (!res.next()) {
                stmt.close();
                conn.close();
            }
            else {
                do {
                    Post current = new Post();

                    current.setId(res.getInt("post_id"));
                    current.setShared(group);
                    current.setSharer(UserFactory.getInstance().getUserById(res.getInt("sharer")));
                    current.setContent(res.getString("content"));
                    current.setPostType(this.postTypeFromInt(res.getInt("type")));
                    current.setPostContent(res.getString("postContent"));
                    
                    postList.add(current);

                } while(res.next());
                
                stmt.close();
                conn.close();
                return postList;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }
    
    public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "jackmedda", "jackjack");
            
            String query = 
                      "insert into posts (post_id, shared_on_user, "
                    + "shared_user, shared_group, sharer, content, type, postContent) "
                    + "values (default, ? , ? , ? , ? , ?, ?, ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            if(post.getShared() instanceof User) {
                stmt.setBoolean(1, true);
                stmt.setInt(2, ((User)post.getShared()).getId());
                //setInt non può essere posto a null
                stmt.setString(3, null);
            }
            else {
                stmt.setBoolean(1, false);
                //setInt non può essere posto a null
                stmt.setString(2, null);
                stmt.setInt(3, ((Group)post.getShared()).getId());
            }
            stmt.setInt(4, post.getSharer().getId());
            stmt.setString(5, post.getContent());            
            stmt.setInt(6, this.postTypeFromEnum(post.getPostType()));
            stmt.setString(7, post.getPostContent());
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private Post.Type postTypeFromInt(int type){
        
        if(type == 2)
            return Post.Type.IMAGE;
        
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type){
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if(type == Post.Type.TEXT)
                return 1;
            else
                return 2;
    }
}