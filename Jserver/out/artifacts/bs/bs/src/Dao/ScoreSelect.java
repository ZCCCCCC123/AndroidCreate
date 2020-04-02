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

public class ScoreSelect {
    public static List<Score> SelectScore(int id, int cid)throws ClassNotFoundException, SQLException {

        List<Score> scores = new ArrayList<>();
        Connection conn= Getconn.getConnection();
        String sql="select * from score where id=? AND cid=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setLong(1, id);
        pst.setLong(2, cid);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Score score=new Score();
            score.setId(rs.getInt("id"));
            score.setCid(rs.getInt("cid"));

            score.setJieci(rs.getInt("jieci"));
            score.setScore(rs.getInt("score"));
            scores.add(score);
        }
        return scores;
    }
}
