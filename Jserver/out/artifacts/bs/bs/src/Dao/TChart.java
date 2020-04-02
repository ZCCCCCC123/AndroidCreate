package Dao;

import Unit.Getconn;
import model.Course;
import model.Score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TChart {
    public static List<Score> TChart(int cid)throws ClassNotFoundException, SQLException {

        List<Score> scores = new ArrayList<>();
        Connection conn= Getconn.getConnection();
        String sql="select cid,jieci,AVG(score.score) score from score where cid=? GROUP BY jieci  ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setLong(1, cid);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Score score=new Score();
            score.setCid(rs.getInt("cid"));
            score.setJieci(rs.getInt("jieci"));
            score.setScore(rs.getInt("score"));
            scores.add(score);
        }
        return scores;
    }
}
