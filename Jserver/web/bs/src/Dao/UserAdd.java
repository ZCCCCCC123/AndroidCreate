package Dao;

import Unit.Getconn;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAdd {
    public static boolean AddUser(User user)throws ClassNotFoundException, SQLException
    {
        Connection conn= Getconn.getConnection();
//        user.setPassword("12345");
        String sql="INSERT INTO user( name , age , sex , identity , college , profession , likes ,  phoneNumber ,trainDate , modifyDateTime ,password )VALUE(?,?,?,?,?,?,?,?,?,?,'12345')";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, user.getName());
        pst.setLong(2, user.getAge());
        pst.setString(3, user.getSex());
        pst.setString(4, user.getIdentity());
        pst.setString(5, user.getCollege());
        pst.setString(6, user.getProfession());
        pst.setString(7, user.getLike());
        pst.setString(8, user.getPhoneNumber());
        pst.setString(9, user.getTrainDate());
        pst.setString(10, user.getModifyDateTime());
        pst.setString(10, user.getPassword());
        int rs=pst.executeUpdate();
        if(rs>0)
            return true;
        else
            return false;

    }
}
