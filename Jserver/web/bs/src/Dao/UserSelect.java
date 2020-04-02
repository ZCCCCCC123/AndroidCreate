package Dao;

import Unit.Getconn;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSelect {
    public static List<User> SelectUser(List<User> users)throws ClassNotFoundException, SQLException
    {

        Connection conn= Getconn.getConnection();
        String sql="select * from user";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setSex(rs.getString("sex"));
            user.setIdentity(rs.getString("identity"));
            user.setCollege(rs.getString("college"));
            user.setProfession(rs.getString("profession"));
            user.setLike(rs.getString("likes"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setTrainDate(rs.getString("trainDate"));
            user.setModifyDateTime(rs.getString("modifyDateTime"));
            users.add(user);
        }
        return users;

    }

}
