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
public class GroupFactory {
    
    private static GroupFactory singleton;

    public static GroupFactory getInstance() {
        if (singleton == null) {
            singleton = new GroupFactory();
        }
        return singleton;
    }

    private List<Group> listGroups = new ArrayList<>();

    private GroupFactory() {
        
        UserFactory userFactory = UserFactory.getInstance();

        Group group1 = new Group();
        group1.setId(0);
        group1.setUser(userFactory.getUserById(0));
        group1.setUser(userFactory.getUserById(1));
        group1.setUser(userFactory.getUserById(3));
        group1.setGroup(new PairGroup("Fuori Corso",""));

        Group group2 = new Group();
        group2.setId(1);
        group2.setUser(userFactory.getUserById(0));
        group2.setUser(userFactory.getUserById(1));
        group2.setUser(userFactory.getUserById(2));
        group2.setGroup(new PairGroup("Mantenuti",""));

        Group group3 = new Group();
        group3.setId(2);
        group3.setUser(userFactory.getUserById(1));
        group3.setUser(userFactory.getUserById(2));
        group3.setUser(userFactory.getUserById(3));
        group3.setGroup(new PairGroup("Pignette",""));

        Group group4 = new Group();
        group4.setId(3);
        group4.setUser(userFactory.getUserById(0));
        group4.setUser(userFactory.getUserById(2));
        group4.setUser(userFactory.getUserById(3));
        group4.setGroup(new PairGroup("Gureu",""));

        listGroups.add(group1);
        listGroups.add(group2);
        listGroups.add(group3);
        listGroups.add(group4);
    }

    public Group getGroupById(int id) {
        for (Group group: this.listGroups) {
            if (group.getId() == id) {
                return group;
            }
        }
        return null;
    }

    public List<Group> getGroupsList(User usr) {

        List<Group> listGroups = new ArrayList<>();

        for (Group group : this.listGroups) {
            if (group.getUserList().contains(usr)) {
                listGroups.add(group);
            }
        }
        return listGroups;
    }
    
    public List<Group> getOtherGroups(Group grp) {

        List<Group> listGroups = new ArrayList<>();

        for (Group group : this.listGroups) {
            if (!group.equals(grp)) {
                listGroups.add(group);
            }
        }
        return listGroups;
    }
}
