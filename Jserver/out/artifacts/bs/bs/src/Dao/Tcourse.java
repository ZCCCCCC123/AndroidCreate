package Dao;

import Unit.Getconn;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tcourse {
    public static List<Course> Tcourse(long id)throws ClassNotFoundException, SQLException {

        List<Course> courses = new ArrayList<>();
        Connection conn= Getconn.getConnection();
        String sql="select cid,coursename,course.teacher,weekfrom,weekto,weektype,day,lessonfrom,lessonto,place from course LEFT OUTER JOIN user ON course.teacher=user.name where user.id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setLong(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Course course=new Course();
            course.setCid(rs.getInt("cid"));
            course.setCoursename(rs.getString("coursename"));
            course.setTeacher(rs.getString("teacher"));
            course.setWeekfrom(rs.getInt("weekfrom"));
            course.setWeekto(rs.getInt("weekto"));
            course.setWeektype(rs.getInt("weektype"));
            course.setDay(rs.getInt("day"));
            course.setLessonfrom(rs.getInt("lessonfrom"));
            course.setLessonto(rs.getInt("lessonto"));
            course.setPlace(rs.getString("place"));
            courses.add(course);
        }
        return courses;
    }
}
