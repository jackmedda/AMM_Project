/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.classi;

/**
 *
 * @author Giacomo
 */
public class Post {

    public enum Type {
        TEXT, IMAGE
    };

    private int id;
    private User user;
    private Group group;
    private Object sharer;
    private String content;
    private Type postType;
    private String postContent;

    public Post() {
        this.id = -1;
        this.user = null;
        this.group = null;
        this.sharer = null;
        this.content = null;
        this.postType = null;
        this.postContent = null;
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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * @return the sharer
     */
    public Object getSharer() {
        return sharer;
    }

    /**
     * @param sharer the sharer to set
     */
    public void setSharer(Object sharer) {
        this.sharer = sharer;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }

    /**
     * @return the postContent
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * @param postContent the postContent to set
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
