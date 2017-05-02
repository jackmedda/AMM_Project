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
        post1.setGroup(groupFactory.getGroupsById(-1));
        post1.setSharer(post1.getUser().getId() == -1 ? post1.getUser() : post1.getGroup());
        
        Post post2 = new Post();
        post2.setContent("Cassato!!!");
        post2.setId(1);
        post2.setUser(userFactory.getUserById(-1));
        post2.setGroup(groupFactory.getGroupsById(0));
        post2.setSharer(post2.getUser().getId() == -1 ? post2.getUser() : post2.getGroup());
        post2.setPostType(Post.Type.IMAGE);
        post2.setPostContent("images/cookieMonster.gif");

        Post post3 = new Post();
        post3.setContent("Epico, impossibile non guardarlo!!");
        post3.setId(2);
        post3.setUser(userFactory.getUserById(2));
        post3.setGroup(groupFactory.getGroupsById(-1));
        post3.setSharer(post3.getUser().getId() == -1 ? post3.getUser() : post3.getGroup());
        post3.setPostType(Post.Type.TEXT);
        post3.setPostContent("https://www.youtube.com/watch?v=FWHneYtED8I");

        Post post4 = new Post();
        post4.setContent("I need ansioliticy");
        post4.setId(3);
        post4.setUser(userFactory.getUserById(-1));
        post4.setGroup(groupFactory.getGroupsById(2));
        post4.setSharer(post4.getUser().getId() == -1 ? post4.getUser() : post4.getGroup());

        Post post5 = new Post();
        post5.setContent("");
        post5.setId(4);
        post5.setUser(userFactory.getUserById(3));
        post5.setGroup(groupFactory.getGroupsById(-1));
        post5.setSharer(post5.getUser().getId() == -1 ? post5.getUser() : post5.getGroup());

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
            if (post.getUser().equals(usr)) {
                listaPosts.add(post);
            }
        }
        return listaPosts;
    }
    
    public List getPostList(Group group) {

        List<Post> listaPosts = new ArrayList<>();

        for (Post post : this.listaPost) {
            if (post.getGroup().equals(group)) {
                listaPosts.add(post);
            }
        }
        return listaPosts;
    }
}