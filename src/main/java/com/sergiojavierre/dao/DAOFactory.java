package com.sergiojavierre.dao;

import com.sergiojavierre.dao.users.DAOUsers;
import com.sergiojavierre.dao.users.DAOUsersMySQL;
import com.sergiojavierre.dao.users.DAOUsersRAM;

import java.util.Date;

public class DAOFactory {

    private static DAOFactory daoFactory;
    //entities
    private DAOUsers daoUsers;

    public DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOUsers getDaoUsers(){
        if(this.daoUsers == null){
            this.daoUsers = new DAOUsersMySQL();
        }
        return this.daoUsers;
    }

}
