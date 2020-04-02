package Dao;

import Unit.Getconn;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFind {
    public static User FindUser( long id)throws ClassNotFoundException, SQLException
    {

        Connection conn= Getconn.getConnection();

        String sql="select * from user where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setLong(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
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
            return user;
        }
        else
            return null;

    }

}
