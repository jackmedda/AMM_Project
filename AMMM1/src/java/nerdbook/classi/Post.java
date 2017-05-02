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

    private int id;
    private User user;
    private String content;
    private boolean imagePresent;
    private String imagePath;

    public Post() {
        this.id = 0;
        this.user = null;
        this.content = "";
        this.imagePresent = false;
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
     * @return the imagePresent
     */
    public boolean isImagePresent() {
        return imagePresent;
    }

    /**
     * @param imagePresent the imagePresent to set
     */
    public void setImagePresent(boolean imagePresent) {
        this.imagePresent = imagePresent;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
