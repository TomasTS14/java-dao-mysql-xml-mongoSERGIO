package com.sergiojavierre;

import com.sergiojavierre.dao.DAOFactory;
import com.sergiojavierre.entities.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user = new User("sergiojavierre","1234", "sergio@twitter.com");
        User user2 = new User("test","1234", "test@twitter.com");


        DAOFactory.getInstance().getDaoUsers().register(user);
        DAOFactory.getInstance().getDaoUsers().register(user2);

        List<User> users = DAOFactory.getInstance().getDaoUsers().read();
        System.out.println(users);

        User testLogin = DAOFactory.getInstance().getDaoUsers().login(user2);
        System.out.println("Login ok: "+testLogin);
        User testLogin2 = DAOFactory.getInstance().getDaoUsers().login(new User("","",""));
        System.out.println("Login fail: "+testLogin2);

    }

}
