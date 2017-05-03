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
public class PostFactory {
    
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private List<Post> listaPost = new ArrayList<>();

    private PostFactory() {
        
        UserFactory userFactory = UserFactory.getInstance();
        GroupFactory groupFactory = GroupFactory.getInstance();

        Post post1 = new Post();
        post1.setContent("Oggi al caddozzone si va a festeggiare!!");
        post1.setId(0);
        post1.setUser(userFactory.getUserById(0));
        post1.setGroupPost(groupFactory.getGroupById(-1));
        post1.setSharer(post1.getUser().getName()+ " " + post1.getUser().getSurname());
        post1.setSharerImagePath(post1.getUser().getProfImagePath());
        post1.setPostType(Post.Type.TEXT);
        post1.setPostContent("");
        
        Post post2 = new Post();
        post2.setContent("Cassato!!!");
        post2.setId(1);
        post2.setUser(userFactory.getUserById(1));
        post2.setGroupPost(groupFactory.getGroupById(-1));
        post2.setSharer(post2.getUser().getName()+ " " + post2.getUser().getSurname());
        post2.setSharerImagePath(post2.getUser().getProfImagePath());
        post2.setPostType(Post.Type.IMAGE);
        post2.setPostContent("images/cookieMonster.gif");

        Post post3 = new Post();
        post3.setContent("Epico, impossibile non guardarlo!!");
        post3.setId(2);
        post3.setUser(userFactory.getUserById(2));
        post3.setGroupPost(groupFactory.getGroupById(-1));
        post3.setSharer(post3.getUser().getName() + " " + post3.getUser().getSurname());
        post3.setSharerImagePath(post3.getUser().getProfImagePath());
        post3.setPostType(Post.Type.TEXT);
        post3.setPostContent("https://www.youtube.com/watch?v=FWHneYtED8I");

        Post post4 = new Post();
        post4.setContent("I need ansioliticy");
        post4.setId(3);
        post4.setUser(userFactory.getUserById(-1));
        post4.setGroupPost(groupFactory.getGroupById(2));
        post4.setSharer(post4.getGroupPost().getGroup().getName());
        post4.setSharerImagePath(post4.getGroupPost().getGroup().getImagePath());
        post4.setPostType(Post.Type.TEXT);
        post4.setPostContent("");

        Post post5 = new Post();
        post5.setContent("");
        post5.setId(4);
        post5.setUser(userFactory.getUserById(3));
        post5.setGroupPost(groupFactory.getGroupById(-1));
        post5.setSharer(post5.getUser().getName() + " " + post5.getUser().getSurname());
        post5.setSharerImagePath(post5.getUser().getProfImagePath());
        post5.setPostType(Post.Type.TEXT);
        post5.setPostContent("");

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(User usr) {

        List<Post> listaPosts = new ArrayList<>();

        for (Post post : this.listaPost) {
            if (post.getUser() != null && post.getUser().equals(usr)) {
                listaPosts.add(post);
            }
        }
        return listaPosts;
    }
    
    public List getPostList(Group group) {

        List<Post> listaPosts = new ArrayList<>();

        for (Post post : this.listaPost) {
            if (post.getGroupPost() != null && post.getGroupPost().equals(group)) {
                listaPosts.add(post);
            }
        }
        return listaPosts;
    }
}