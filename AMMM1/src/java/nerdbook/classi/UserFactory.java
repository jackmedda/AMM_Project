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
        user0.setDate("Incrocio");
        user0.setPassword("123");
        user0.setUrlProfImage("img/djanniprofilo.jpg");

        User user1 = new User();
        user1.setId(0);
        user1.setName("Jack");
        user1.setSurname("Medda");
        user1.setDate("1996-03-20");
        user1.setPassword("123789");
        user1.setUrlProfImage("img/djanniprofilo.jpg");

        User user2 = new User();
        user2.setId(1);
        user2.setName("Cookie");
        user2.setSurname("Monster");
        user2.setDate("1666-08-22");
        user2.setPassword("qwerty");
        user2.setUrlProfImage("img/user1.gif");

        User user3 = new User();
        user3.setId(2);
        user3.setName("Gym");
        user3.setSurname("doIt@gmail.com");
        user3.setDate("User Sacro di Birmania");
        user3.setPassword("123");
        user3.setUrlProfImage("img/user2.jpg");

        User user4 = new User();
        user4.setId(3);
        user4.setName("ChaoPovery");
        user4.setSurname("r1tchb1tch@gmail.com");
        user4.setDate("Ocicat");
        user4.setPassword("123");
        user4.setUrlProfImage("img/user3.jpg");

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
            if(utente.getName().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
}
