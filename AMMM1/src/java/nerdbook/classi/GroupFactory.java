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

    private List<Group> listAllGroups = new ArrayList<>();

    private GroupFactory() {
        
        UserFactory userFactory = UserFactory.getInstance();

        Group groups1 = new Group();
        groups1.setId(0);
        groups1.setUser(userFactory.getUserById(0));
        groups1.setUser(userFactory.getUserById(1));
        groups1.setUser(userFactory.getUserById(3));
        groups1.setGroup(new PairGroup("FuoriCorso",""));

        Group groups2 = new Group();
        groups2.setId(1);
        groups2.setUser(userFactory.getUserById(0));
        groups2.setUser(userFactory.getUserById(1));
        groups2.setUser(userFactory.getUserById(2));
        groups2.setGroup(new PairGroup("Mantenuti",""));

        Group groups3 = new Group();
        groups3.setId(2);
        groups3.setUser(userFactory.getUserById(1));
        groups3.setUser(userFactory.getUserById(2));
        groups3.setUser(userFactory.getUserById(3));
        groups3.setGroup(new PairGroup("Pignette",""));

        Group groups4 = new Group();
        groups4.setId(3);
        groups4.setUser(userFactory.getUserById(0));
        groups4.setUser(userFactory.getUserById(2));
        groups4.setUser(userFactory.getUserById(3));
        groups4.setGroup(new PairGroup("Gureu",""));

        listAllGroups.add(groups1);
        listAllGroups.add(groups2);
        listAllGroups.add(groups3);
        listAllGroups.add(groups4);
    }

    public Group getGroupsById(int id) {
        for (Group groups : this.listAllGroups) {
            if (groups.getId() == id) {
                return groups;
            }
        }
        return null;
    }

    public List getGroupsList(User usr) {

        List<Group> listGroups = new ArrayList<>();

        for (Group group : this.listAllGroups) {
            if (group.getUserList().contains(usr)) {
                listGroups.add(group);
            }
        }
        return listGroups;
    }
}
