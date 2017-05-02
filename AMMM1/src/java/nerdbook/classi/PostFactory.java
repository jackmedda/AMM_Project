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

        Post post1 = new Post();
        post1.setContent("Ciao, miei schiavi. Datemi cibo! Adesso! Miaomiaomiaomiaomiao!");
        post1.setId(0);
        post1.setUser(userFactory.getUserById(0));

        Post post2 = new Post();
        post2.setContent("");
        post2.setId(1);
        post2.setUser(userFactory.getUserById(0));
        post2.setImagePresent(true);
        post2.setImagePath("img/djanni1.jpg");

        Post post3 = new Post();
        post3.setContent("");
        post3.setId(2);
        post3.setUser(userFactory.getUserById(0));
        post3.setImagePresent(true);
        post3.setImagePath("img/djanni2.jpg");

        Post post4 = new Post();
        post4.setContent("I need ansioliticy");
        post4.setId(3);
        post4.setUser(userFactory.getUserById(1));

        Post post5 = new Post();
        post5.setContent("");
        post5.setId(4);
        post5.setUser(userFactory.getUserById(1));
        post5.setImagePresent(true);
        post5.setImagePath("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");

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
}
