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
public class UserFactory {
    
    private static UserFactory singleton;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }

    private List<User> listaUtenti = new ArrayList<>();

    private UserFactory() {
        
        User user0 = new User();
        user0.setId(10);
        user0.setName(null);
        user0.setSurname(null);
        user0.setDate("2012-12-21");
        user0.setUsername("uncompleted");
        user0.setPassword("123");
        user0.setProfImagePath("img/djanniprofilo.jpg");

        User user1 = new User();
        user1.setId(0);
        user1.setName("Jack");
        user1.setSurname("Medda");
        user1.setDate("1996-03-20");
        user1.setUsername("jackmedda");
        user1.setPassword("123789");
        user1.setProfImagePath("img/djanniprofilo.jpg");

        User user2 = new User();
        user2.setId(1);
        user2.setName("Cookie");
        user2.setSurname("Monster");
        user2.setDate("1666-08-22");
        user2.setUsername("cookiem");
        user2.setPassword("qwerty");
        user2.setProfImagePath("images/cookieMonsterProf.jpg");

        User user3 = new User();
        user3.setId(2);
        user3.setName("Baule");
        user3.setSurname("Gigante");
        user3.setDate("1981-10-08");
        user3.setUsername("baulegig");
        user3.setPassword("789");
        user3.setProfImagePath("img/user2.jpg");

        User user4 = new User();
        user4.setId(3);
        user4.setName("Giampi");
        user4.setSurname("Galeazzi");
        user4.setDate("1999-01-01");
        user4.setUsername("giampiGal");
        user4.setPassword("polio");
        user4.setProfImagePath("img/user3.jpg");
        
        listaUtenti.add(user0);
        listaUtenti.add(user1);
        listaUtenti.add(user2);
        listaUtenti.add(user3);
        listaUtenti.add(user4);
    }

    public User getUserById(int id) {
        for (User utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(User utente : this.listaUtenti){
            if(utente.getUsername().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
    
    public List<User> getUserFriends(User user) {
        List<User> friendsList = new ArrayList<>();
        
        for(User utente : this.listaUtenti) {
            if(user.getId() != utente.getId() && utente.getId() != 10)
                friendsList.add(utente);
        }
        
        return friendsList;
    }
}
