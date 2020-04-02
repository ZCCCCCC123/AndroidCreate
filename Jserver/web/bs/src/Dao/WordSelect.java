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

public class WordSelect {
    public static List<Score> SelectWord(int id)throws ClassNotFoundException, SQLException {

        List<Score> scores = new ArrayList<>();
        Connection conn= Getconn.getConnection();
        String sql="select id,cid,AVG(score.score) score from score where id=? GROUP BY cid  ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setLong(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Score score=new Score();
            score.setId(rs.getInt("id"));
            score.setCid(rs.getInt("cid"));
            score.setScore(rs.getInt("score"));
            scores.add(score);
        }
        return scores;
    }
}
