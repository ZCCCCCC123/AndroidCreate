package Dao;

import Unit.Getconn;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseChoice {
    public static List<User> ChoiceCourse(int cid)throws ClassNotFoundException, SQLException
    {

        Connection conn= Getconn.getConnection();
        String sql="select user.id, name, profession from user LEFT OUTER JOIN choicecourse ON user.id=choicecourse.id where choicecourse.cid=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setLong(1, cid);
        ResultSet rs = pst.executeQuery();
        List<User> users = new ArrayList<User>();
        while (rs.next()) {
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setProfession(rs.getString("profession"));
            users.add(user);
        }
        return users;

    }

}
