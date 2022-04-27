package com.sergiojavierre.dao.users;

import com.mysql.jdbc.Connection;
import com.sergiojavierre.entities.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsersMySQL implements DAOUsers{

    Connection conn = null;

    String IP, database, user, password;
    public DAOUsersMySQL() {
        IP = "192.168.8.26";
        database = "twitter";
        user = "elon";
        password = "1234";

        try {
            String uri = "jdbc:mysql://" + IP + "/" + database + "?characterEncoding=utf8&" +
                    "user=" + user + "&password=" + password;
            conn = (Connection) DriverManager.getConnection(uri);

        } catch (
                SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public Boolean register(User user) {
        String sql = "insert into users values ('"+user.getAlias()+"','"+user.getEmail()+"','"+user.getPassword()+"')";
        try {
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User login(User user) {
        String sql = "select * from users where alias = '"+user.getAlias()+"' and password = '"+user.getPassword()+"'";
        return null;
    }

    @Override
    public List<User> read() {
        List<User> users = new ArrayList<>();
        String sql = "select alias, email from users";
        try {
            ResultSet result = conn.createStatement().executeQuery(sql);
            while(result.next()){
                String alias = result.getString("alias");
                String email = result.getString("email");
                User user = new User(alias,email);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
