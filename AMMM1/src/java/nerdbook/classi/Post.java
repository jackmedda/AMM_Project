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
    private Shared sha;
    private User sharer;
    private String content;
    private Type postType;
    private String postContent;

    public Post() {
        this.id = -1;
        this.sha = null;
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
     * @return the shahor
     */
    public Shared getShared() {
        return sha;
    }

    /**
     * @param sha the shahor to set
     */
    public void setShared(Shared sha) {
        this.sha = sha;
    }

    /**
     * @return the sharer
     */
    public User getSharer() {
        return sharer;
    }

    /**
     * @param sharer the sharer to set
     */
    public void setSharer(User sharer) {
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
